
/* ###############################################################################
		On DOM Ready funtions
################################################################################*/

$(document).ready(function()
{
    /* ###############################################################################
    Google Search control
    ################################################################################*/
    //functionality to toggle search field background image

    //search field background image URL
    var gsaImageUrl = "/templates/portal/images/google_anglia.jpg";

    if ($("#google-search-field").attr("value") == "")
    {
        $("#google-search-field").css("background-image", "url(" + gsaImageUrl + ")").css("background-repeat", "no-repeat").css("background-position", "center center");
    }
    else
    {
        $("#google-search-field").css("background-image", "");
    }
    //then set up event hanlder to deal with state change
    $("#google-search-field").blur(function()
    {
        if ($("#google-search-field").attr("value") == "")
        {
            $("#google-search-field").css("background-image", "url(" + gsaImageUrl + ")").css("background-repeat", "no-repeat").css("background-position", "center center");
        }
    });

    $("#google-search-field").focus(function()
    {
        $("#google-search-field").css("background-image", "");
    });

    // rewrite form submit action - gets overwritten by .net on load
    $("#google-search-form").attr("action", "http://search.anglia.ac.uk/search");
    
    /* ###############################################################################
    End Google Search control
    ################################################################################*/
});

/* ###############################################################################
Utility Functions
################################################################################*/

function ajaxLoadHTML(url, container) {
    //check if a querystring allready exists i.e. add vs. append
    var delim = getDelimeter(url);
    var rand = randomNumber();

    //ajax URL
    var ajaxURL = url + delim + "r=" + rand;

    //target container for content
    var responseContainer = "#" + container;

    // load animation
    $(responseContainer).html("<div id='ajaxloader-animation'><img src='/templates/portal/images/ajaxloader.gif' alt='Loading content.. Please wait'/></div>")

    //make request
    $(responseContainer).load(ajaxURL, function() {
        $(responseContainer).slideDown('slow');
    });
}

// fully featured ajax script
// url - url of service to call
// container - container to write output to
// messagecontainer - container to write message to - set to null if not needed
// service - Service Name e.g. library service
function getAjaxContent(url, container, messagecontainer, service) {
    if (url != "" && container != "") {
        var delim = getDelimeter(url);
        var rand = randomNumber();

        //ajax URL
        var ajaxURL = url + delim + "r=" + rand;

        if (messagecontainer != null) {
            writeMsg(messagecontainer, 'Loading ' + service);
        }

        $.ajax({
            type: "GET",
            url: ajaxURL,
            success: function(out) {
                $(container).html(out);
            },

            error: function() {
                if (messagecontainer != null) {
                    writeMsg(messagecontainer, 'Could not load ' + service);
                }
            },

            complete: function() {
                if (messagecontainer != null) {
                    writeMsg(messagecontainer, "");
                }
            }
        });
    }
    return false;
}

// generqates a random number - used by ajax scripts
function randomNumber() {
    //random number to keep ajax calls fresh
    var adjustedHigh = (parseFloat(1024) - parseFloat(1)) + 1;
    var numRand = Math.floor(Math.random() * adjustedHigh) + parseFloat(1);
    return numRand;
}

// figures out what delimeter top use when appending to querystring
function getDelimeter(url) {
    //check if a querystring already exists i.e. add vs. append
    var delim = "?";
    if (url.indexOf("?") > 0) {
        var delim = "&";
    }
    return delim;
}

// utility that writes a message to a container
function writeMsg(messageContainer, messageText) {
    $("#" + messageContainer).html(messageText);
} 

// takes input string regex matches text and numbers and leaves that as is, escapes other chars, spaces formatted as '+'
function URLEncode(clearString) 
{
  var output = '';
  var x = 0;
  clearString = clearString.toString();
  var regex = /(^[a-zA-Z0-9_.]*)/;
  while (x < clearString.length) 
	{
    var match = regex.exec(clearString.substr(x));
		if (match != null && match.length > 1 && match[1] != '') 
		{
    	output += match[1];
      x += match[1].length;
    } 
		else 
		{
        var charCode = clearString.charCodeAt(x);
			if(charCode == 32)
			{
				output += '+';
			}
			else
			{
        var hexVal = charCode.toString(16);
        output += '%' + ( hexVal.length < 2 ? '0' : '' ) + hexVal.toUpperCase();
			}
     x++;
    }
  }
  return output;
}