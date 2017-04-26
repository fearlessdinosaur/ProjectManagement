# ProjectManagement
Project Management Software developed for OOP Assignment 3
Students on team were David Craig Fox, Thomas Cronin and Lauren Keenan Brennan
Languages: Python,Java,Sql (pc)



We created a Project Manager Softeware. Users would either login or sign up and then be brought to the main page. Users are then able to create and join a team, create events and then view them. We wanted to create an application that could be useful to anyone taking part in a project, whether it be in a group or by themselves.

Thomas: Created csv files that stored the information of the user and the event details in a file, created a function that reads the csv file

Lauren: I was on the front end part of the project. I used JavaFX to create interactive UI  and css to style it. I was able to incorporate two different styles into the programme (simple day and night) and the user can choose which one they prefer. I learned a lot by using JavaFX as it was a completely new thing to me but I found it incredibly useful in creating UI's and will be using it in the future.

David: I wrote the serverside section of the project. I used Python to build a server and SQlite to run the database.I created a sign up and login system using http get and post, and created a team creation system to track users.I learned a large amount about creating and sending server data a found the work to be extremely interesting.

How to Run!
client:
When you run the file, you can either login if you already have an account or else you can sign up and create an account. After you have done this you then enter the main page. Here you should go to the top right of the page and create a team if it does not exist already, if it does then you should just join a team! after this you can create events and then view the dates in the calender field!

server: 
to run the server you must go into the server code (main.py in the serverside folder) and change the ip to your laptops ip (line 181). Leave the socket alone. Then go into the client class of the java code (client.java in the ie.dit package) and change the ip adresses in lines: 33,124,141,149 and 157 (apologies for this,this is due to the server being hosted locally on the laptop)

[![IMAGE ALT TEXT](https://youtu.be/CV21OkYQp-A/0.jpg)](https://youtu.be/CV21OkYQp-A "Video Title")
https://youtu.be/CV21OkYQp-A
