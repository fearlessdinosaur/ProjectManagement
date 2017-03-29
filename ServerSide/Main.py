from http.server import BaseHTTPRequestHandler, HTTPServer
import simplejson


# HTTPRequestHandler class
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
            if output['Code'] == 1 :
                print("Storing Input")
            file.write("\n"+'name is '+output['name'])
            file.close()
            return
        except:
            pass

def run():
    print('starting server...')

    server_address = ('192.168.43.215', 8081)
    httpd = HTTPServer(server_address, Server)
    print('running server...')
    httpd.serve_forever()


run()
