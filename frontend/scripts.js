$("#save_form").submit(function(event){
	$.ajax({
	    url: "http://localhost:8080/evento/",
	    method: "POST",
	    data: JSON.stringify({
	    	event :  $("#name").val(),
	    	revenue : $("#revenue").val()
	    }),
	    contentType: 'application/json',
	    success: function(data){ 
	        data = $.parseJSON(data);
	        console.log(data);
	        alert("Nome: " + data);
	    }, 
	    error: function(e){
	        alert("Erro: " + e);
	    } 

    }); 

    event.preventDefault();
});

$("#create_form").submit(function(event){
	$.ajax({
		    url: "http://localhost:8080/evento/all",
		    method: "GET",
		    success: function(data){ 
		        data = JSON.stringify(data);
		        createDivTimeline(data);
		    }, 
		    error: function(e){
		        alert("Erro: " + e);
		    } 
	    }); 

    event.preventDefault();
});

function createDivTimeline(result){
	result = jQuery.parseJSON(result);
	var content = "";
	content += JSON.stringify(result, null, 4);

	$("#timeline").val(content);
}

$("#autocomplete").keyup(function(){
	var input = $("#autocomplete").val();
    if(input.length > 1){
		$.ajax({
		    url: "http://localhost:8080/evento?event="+input,
		    method: "GET",
		    success: function(data){ 
		        data = JSON.stringify(data);
		        createDivResult(data);
		    }, 
		    error: function(e){
		        alert("Erro: " + e);
		    } 
	    }); 
    }   
});

function createDivResult(result){
	result = jQuery.parseJSON(result);
	var content = '<br><br><br><br><br><table id="customers">';
	content += "<tr><td> Nome </td> <td>Revenue</td></tr>";
	for(var index in result) {
	   content += "<tr>";
	   content += "<td>"+result[index].event + "</td>";
	   content += "<td>"+result[index].revenue + "</td>";
	   content += "</tr>";
	}
	content += "</table>";
	$("#div-result").html(content);
}