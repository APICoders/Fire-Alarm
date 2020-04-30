
$(document).ready(function () {
    getSensorDetails();
    
})


function getSensorDetails() {
    
    var colorMap = {
        1 : '#00ff009a',
        2 : '#33cc33b6',
        3 : '#ccff33b9',
        4 : '#ffcc00b6',
        5 : '#ff6600c7',
        6 : '#e62e00be',
        7 : '#ff0000b0',
        8 : '#cc0000b9',
        9 : '#990000ad',
        10: '#800000c2'
    };
    

   $.ajax({
        url: 'http://localhost:8081/FireAlarmMonitor/rest/fireAlarms',
        method: 'GET',
        dataType: 'json',
        success: function (data,errorThrown) {
            var tableBody = $('#FireAlarmTable tbody');
            tableBody.empty();
            $(data).each(function (index, element) {
             
                var color = $(element.smokeLevel)

            
                

                tableBody.append('<tr><td>'+element.id+'</td><td>'+element.status+'</td><td>'+element.roomNo+'</td><td>'+element.floorNo+'</td><td id = "smoke" >'+element.smokeLevel+'</td><td id="co2">'+element.co2Level+'</td></tr>');
                

                $('#FireAlarmTable td:nth-child(5)').css('background-color', function(){
                    return colorMap[$(this).text()] || '';
                });

                $('#FireAlarmTable td:nth-child(6)').css('background-color', function(){
                    return colorMap[$(this).text()] || '';
                });

                var tds = document.querySelectorAll("td:nth-child(2)");
                            for (var i = 0; i < tds.length; i++){
                            if (tds[i].firstChild.nodeValue ==0){
                             tds[i].firstChild.nodeValue = "Inactive";
                            }else{
                                tds[i].firstChild.nodeValue = "Active";
                            }
                            }

         } ) },
        error: function (jqXHR,error,errorThrown) {
            alert(error);
        }
    });
}


// function getSensorDetails(){

//     fetch('http://localhost:8081/FireAlarmMonitor/rest/fireAlarms')
//     .then((res) => res.json())
//     .then((data) => {
//       data.forEach(function(element){
//         output += '<tr><td>'+element.id+'</td><td>'+element.roomNo+'</td><td>'+element.floorNo+'</td><td>'+element.status+'</td><td>'+element.smokeLevel+'</td><td>'+element.co2Level+'</td></tr>';
//       });
//       document.getElementById('output').innerHTML = output;
//     })
//   }

$(document).ready(function(){
    var fireAlarm = {};
    $('#add').click(function(){
        fireAlarm.id = 1;
        fireAlarm.roomNo = 1;
        fireAlarm.floorNo = 20;
        fireAlarm.status = 1;
        fireAlarm.smokeLevel = 2;
        fireAlarm.co2Level = 1;
        var fireSMS = JSON.stringify(fireAlarm);
        $.ajax({
            url: "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/sendSMS",
            type: "POST",
            data:fireSMS,
            contentType: "application/json",

            success:function(){
                alert('Saved Successfully')
            },
            error:function(error){
                alert(error);
            }

        })
    })
})