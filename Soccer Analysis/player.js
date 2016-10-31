var Client = require('node-rest-client').Client;
var client = new Client();
var express = require('express');
var app = express();
var fs = require("fs");
var path    = require("path");

app.use(express.static(__dirname + '/public'));

app.get('/',function(req,res){
    res.sendFile(path.join(__dirname+'/player.html'));

});

app.get('/listPlayers', function (req, res) {
   client.get("https://fantasy.premierleague.com/drf/bootstrap-static", function(data, response) {
       var players = data.elements;
    //   console.log(players.length);
    //   console.log(players[74].id);
    //   console.log(players[74].first_name);
    //   console.log(players[74].second_name);
       res.end(JSON.stringify(players));
    });
})

app.get('/playerPerformance/:id', function (req, res){
    client.get("https://fantasy.premierleague.com/drf/element-summary/"+req.params.id, function(data, response) {
    //   console.log(data.history_past);
       var history = data.history_past;
       res.end(JSON.stringify(history));
    //   for(i=0;i<history.length;i++) {
    //       console.log(history[i].goals_scored);
    //   }
    //   console.log(response);
    });
})


var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port

   console.log("Example app listening at http://%s:%s", host, port)
})


