from http.server import BaseHTTPRequestHandler, HTTPServer
import simplejson


# HTTPRequestHandler class
class Server(BaseHTTPRequestHandler):
    def do_GET(self):
        # Send response status code
        self.send_response(200)

        # Send headers
        self.send_header('Content-type', 'application/json')
        self.end_headers()

        # Send message back to client
        message = "Hello world!"
        print("responded")
        # Write content as utf-8 data
        self.wfile.write(simplejson.dumps(message))
        return message

    def do_POST(self):
        file = open("WriteFile.txt", "r+")
        dave = file.read()

        try:

            self.send_response(200,"successful post")
            self.send_header('Content-type', 'application/json')
            self.end_headers()
            content_length = int(self.headers['Content-Length'])
            input = simplejson.loads(self.rfile.read(content_length))
            output = simplejson.dumps(input)
            print(output)
            file.write(output)
            file.close()
            return
        except:
            pass

def run():
    print('starting server...')

    # Server settings
    # Choose port 8080, for port 80, which is normally used for a http server, you need root access
    server_address = ('147.252.137.27', 8081)
    httpd = HTTPServer(server_address, Server)
    print('running server...')
    httpd.serve_forever()


run()
