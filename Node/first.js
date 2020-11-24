var express = require('express');
var app = express()
var request = require('request');

app.get("/",function(req,res){ // This code will run when you don't add anything special to the path
	res.end("Hello World (again)");
});

app.get("/dog",function(req,res){ // This code will run when you go to http://localhost:8080/dog

});

app.listen(8080); // the webserver is now running on port 8080.

// To run this, run node first.js in the folder and put http://localhost:8080 into your browser. You should see "Hello World (again)."
