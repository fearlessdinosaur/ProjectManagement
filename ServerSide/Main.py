from http.server import BaseHTTPRequestHandler, HTTPServer
import simplejson
import sqlite3
import urllib
#skeleton code found online
class Server(BaseHTTPRequestHandler):
    def do_GET(self):
        file = open("WriteFile.txt", "r+")

        # Send response status code
        self.send_response(200)
        # Send headers
        self.send_header('Content-type', 'application/json')
        self.end_headers()
        data = file.read()
        print("responded")
        sender = urllib.parse.urlparse(self.path)
        print(sender)
        input = urllib.parse.urlparse(self.path).query
        print(input);
        self.wfile.write(bytes(data, 'UTF-8'))
        return data

    def do_POST(self):
        file = open("WriteFile.txt", "r+")
        dave = file.read()

        try:

            self.send_response(200,"successful post")
            self.send_header('Content-type', 'application/json')
            self.end_headers()
            content_length = int(self.headers['Content-Length'])
            output = simplejson.loads(self.rfile.read(content_length))
            file.write("\n"+output['name'] + " " + output['password'])
            data(output['name'],output['password'])
            file.close()
            return
        except:
            pass


def data(name,password):

    try:
        database = sqlite3.connect('data/userInf.db')
        cursor = database.cursor()
        cursor.execute('''
            CREATE TABLE IF NOT EXISTS user(name TEXT,password TEXT)
        ''')

        database.commit()
        cursor.execute('''INSERT INTO user(name,password) VALUES(?,?)''', (name,password))
        database.commit()
        print(database)
        cursor.execute('''SELECT * FROM user''')
        user1 = cursor.fetchone()
        print(user1[0])
    except sqlite3.OperationalError as msg:
        print(msg)
        raise msg
    finally:
        database.close()


def run():
    print('starting server...')

    server_address = ('192.168.1.19', 8082)
    httpd = HTTPServer(server_address, Server)
    print('running server...')
    httpd.serve_forever()


run()
