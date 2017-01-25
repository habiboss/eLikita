$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true,true).slideDown("400");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true,true).slideUp("400");
            $(this).toggleClass('open');       
        }
    );
    
/*    $('#staff').on('click', function() {
        //alert("s");
       // $("#container").load("/personalDetail #container");
        xhttp.onreadystatechange = function() {
        	  if (this.readyState == 4 && this.status == 200) {
        	    document.getElementById("cont").innerHTML = this.responseText;
        	  }
        	};
        	xhttp.open("GET", "/personalDetail", true);
        	xhttp.send();
});*/
    function loadDoc() {
    	  var xhttp = new XMLHttpRequest();
    	  xhttp.onreadystatechange = function() {
    	    if (this.readyState == 4 && this.status == 200) {
    	      document.getElementById("cont").innerHTML =
    	      this.responseText;
    	    }
    	  };
    	  xhttp.open("GET", "@routes.Application.personalDetail()", true);
    	  xhttp.send();
    	}
});