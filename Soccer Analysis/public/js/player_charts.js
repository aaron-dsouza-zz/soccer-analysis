// Generate all the charts
function generate_charts(data, player_name) {
    var season_names = [];
    var goals_scored = [];
    var assists = [];
    var goals_conceded = [];
    var total_points = [];
    var bonus = [];
    var minutes = [];
    var yellow_cards = [];
    var red_cards = [];
    var clean_sheets = [];
    $.each(data, function(i, season) {
        season_names.push(season.season_name);
        goals_scored.push(season.goals_scored);
        assists.push(season.assists);
        goals_conceded.push(season.goals_conceded);
        total_points.push(season.total_points);
        bonus.push(season.bonus);
        minutes.push(season.minutes);
        yellow_cards.push(season.yellow_cards);
        red_cards.push(season.red_cards);
        clean_sheets.push(season.clean_sheets);
    });
    
    line_chart(season_names, goals_scored, player_name,'goals_scored', 'Goals scored','Past seasons\' goals scored');
    line_chart(season_names, assists, player_name,'assists', 'Assists','Past seasons\' assists made');
    line_chart(season_names, goals_conceded, player_name,'goals_conceded', 'Goals conceded','Past seasons\' goals conceded');

    line_chart(season_names, total_points, player_name,'total_points', 'Total Points','Past seasons\' total points');
    line_chart(season_names, bonus, player_name,'bonus', 'Bonus','Past seasons\' bonus points');
    line_chart(season_names, minutes, player_name,'minutes', 'Minutes played','Past seasons\' minutes played');
    
    line_chart(season_names, yellow_cards, player_name,'yellow_cards', 'Yellow cards','Past seasons\' yellow cards awarded');
    line_chart(season_names, red_cards, player_name,'red_cards', 'Red cards','Past seasons\' red cards awarded');
    line_chart(season_names, clean_sheets, player_name,'clean_sheets', 'Clean sheets','Past seasons\' clean sheets kept');
}

function line_chart(season_names, chart_data, player_name, chart_id, yAxis_title_text, title_text) {
    var options = {
        chart: {
            type: 'line'
        },
        title: {
            text: title_text
        },
        xAxis: {
            categories: season_names
        },
        yAxis: {
            title: {
                text: yAxis_title_text
            }
        },
        series: [{
            name: player_name,
            data: chart_data
        }]
    };
    Highcharts.chart(chart_id, options);
    $("#"+chart_id).show();
}

function setup_toggle_buttons() {
    
    $(".toggle-chart").click(function(){
        var button_id = $(this).attr("id");
        var chart_id = button_id.slice(0, -7);
        $("#"+chart_id).toggle();
    });
}