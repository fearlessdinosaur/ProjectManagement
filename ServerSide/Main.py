from http.server import BaseHTTPRequestHandler, HTTPServer
import simplejson
import sqlite3
import urllib
from random import randint
#skeleton code found online
class Server(BaseHTTPRequestHandler):

    def do_GET(self):
        file = open("WriteFile.txt", "r+")

        # Send response status code
        self.send_response(200)
        # Send headers
        self.send_header('Content-type', 'application/json')
        self.end_headers()
        print("responded")
        sender = urllib.parse.urlparse(self.path)

        input = urllib.parse.parse_qsl(sender[4])
        data = ""
        length=len(input)
        if(length==2):
            group1= input[0]
            group2= input[1]
            item1=group1[1]
            item2=group2[1]
            if(item2=='101'):
                data = GroupJoin(item1)
            if(item2=='102'):
                data = GetGID(item1)
        if(length==3):
            print("in login")
            group1= input[0]
            group2= input[1]
            group3= input[2]
            item1=group1[1]
            item2=group2[1]
            passW=group3[1]
            if(passW == '100'):
                data = Login(item1, item2)

        self.wfile.write(bytes(data, 'UTF-8'))
        return data

    def do_POST(self):
        file = open("WriteFile.txt", "r+")
        dave = file.read()

        try:
            self.send_response(200, "successful post")
            self.send_header('Content-type', 'application/json')
            self.end_headers()
            content_length = int(self.headers['Content-Length'])
            output = simplejson.loads(self.rfile.read(content_length))
            if(output['Code']==1):
                PostUser(output['name'],output['password'])
            if(output['Code']==2):
                id= randint(100000,999999)
                data=groupt(id, output['name'], 'holdPlace',1)
            if(output['Code']==3):
                data=EventMGR(output['GID'],output['EventInfo'],output['Eventname'],output['Date'])
            file.close()
            return data
        except:
            pass

def PostUser(name,password):

    try:
        database = sqlite3.connect('data/database.db')
        cursor = database.cursor()
        cursor.execute('''
            CREATE TABLE if NOT EXISTS user(name TEXT,password TEXT,id INTEGER,groupId INTEGER)
        ''')

        database.commit()
        cursor.execute('''INSERT INTO user(name,password) VALUES(?,?)''', (name,password))
        database.commit()
        cursor.execute('''SELECT * FROM user''')
        user1 = cursor.fetchone()
        print(user1[0])
    except sqlite3.OperationalError as msg:
        print(msg)
        raise msg
    finally:
        database.close()

def Login(name, password):
    database = sqlite3.connect('data/database.db')
    cursor = database.cursor()
    cursor.execute('''SELECT password FROM user WHERE name = ?''', (name,))
    user1=""
    user1=cursor.fetchone()
    if user1[0]== password:
        return '0'
    else:
        return '1'
    
def groupt(gId, gName, admin, adminIp):

    try:
        database = sqlite3.connect('data/database.db')
        cursor = database.cursor()
        print(database)
        cursor.execute('''
            CREATE TABLE IF NOT EXISTS groups(gId INTEGER,gName TEXT,admin TEXT,adminIp INTEGER,PRIMARY KEY(gId))
        ''')
        database.commit()
        cursor.execute('''INSERT INTO groups(gId,gName,admin,adminIp) VALUES(?,?,?,?)''', (gId,gName,admin,adminIp))
        database.commit()
        cursor.execute('''SELECT * FROM groups''')
        group1 = cursor.fetchone()
        print(group1[0])
    except sqlite3.OperationalError as msg:
        print(msg)
        raise msg
    finally:
        database.close()

def GroupJoin(gName):
    database = sqlite3.connect('data/database.db')
    cursor = database.cursor()
    cursor.execute('''SELECT gId FROM groups WHERE gName = ?''', (gName,))
    group1 = cursor.fetchone()
    print(group1)
    if not group1 is None:

        cursor.execute('INSERT INTO user(groupId) values(?)',(group1))
        database.commit()
        print("yaaaas")
        return '0'
    else:
        return "1"
    
def GetGID(gName):
    database = sqlite3.connect('data/database.db')
    cursor = database.cursor()
    cursor.execute('''SELECT gId FROM groups WHERE gName = ?''', (gName,))
    group1 = cursor.fetchone()
    print(group1)
    if not group1 is None:
        return group1
    else:
        return "1"
def EventMGR(GID,info,name,date):
    try:
        database = sqlite3.connect('data/database.db')
        cursor = database.cursor()
        print(database)
        cursor.execute('''
            CREATE TABLE IF NOT EXISTS events(gId INTEGER,name TEXT,date TEXT,info TEXT)
        ''')
        database.commit()
        cursor.execute('''INSERT INTO groups(gId,name,date,info) VALUES(?,?,?,?)''', (GID,name,date,info))
        database.commit()
        cursor.execute('''SELECT * FROM groups''')
        group1 = cursor.fetchone()
        print(group1[0])
    except sqlite3.OperationalError as msg:
        print(msg)
        raise msg
    finally:
        database.close()

def run():
    print('starting server...')

    server_address = ('147.252.137.57', 8082)
    httpd = HTTPServer(server_address, Server)
    print('running server...')
    httpd.serve_forever()


run()
