//cookie name constants
//currently selected tab id (LI id)
var TAB_SELECTED = "TAB_SELECTED";

//cookie to indicate whether sub menu is visible or not
var SUB_MENU_HIDDEN = "SUB_MENU_HIDDEN";

var COOKIE_CHECK = "COOKIE_CHECK";

//toolbar container - contains LI items that control link containers
var navigation_menu = "#main-navigation-menu";

//wrapper for child DIVS containing links related to clicked link
var navigation_submenu = "#main-navigation-submenu";
var navigation_submenu_container = "#main-navigation-submenu-container";

//the suffix is used to associate link container DIVS to their controlling LI hyperlink
//e.g. <li id="international-eu-students"> controls <div id="international-eu-students-links" class="second-level">
var submenu_links_container_suffix = "-links";

// event controllers
//element that triggers the submenu display event handler
var navigation_menu_controller = "#main-navigation-menu ul li a em";

//element adjacent to submenu display event handler - standard hyperlink that provides additional function
var navigation_menu_jump_link = "#main-navigation-menu ul li a";

// id suffix for 'jump links' i.e. not menu controllers
var jump_link_suffix = "-jump-link"

//class assigned to active tab
var active_tab_class = "active";

// hover class for drop down controller 
var navigation_menu_controller_hover = "navigation-menu-controller-hover";

// hover class for drop down controller's associated jump link
var navigation_menu_controller_jump_link_hover = "navigation-menu-controller-jump-link-hover";

// hover class for jump link if used standalone
var navigation_menu_jump_link_hover = "jump-link-hover";

//set up a variable to hold id of tab link clicked - null at first but written to by cookie	
var currentTab = null;

$(document).ready(function()
{

    //this can only happen if cookies are enabled
    if (cookieSetCheck())
    {

        //event handlers		
        // navigation menu controller click
        $(navigation_menu_controller).click(function()
        {
            handleTabClick($(this), true, true);
            return false;
        });

        // navigation menu controller mouseover
        $(navigation_menu_controller).mouseover(function()
        {
            if ($(this).attr("class") != active_tab_class)
            {
                var el = $(this).attr("id");
                setEmHoverClass(el);
                return false;
            }
        });

        // navigation menu controller mouseout
        $(navigation_menu_controller).mouseout(function()
        {
            if ($(this).attr("class") != active_tab_class)
            {
                var el = $(this).attr("id");
                clearEmHoverClass(el)
                return false;
            }
        });

        // navigation menu jump link mouseover
        $(navigation_menu_jump_link).mouseover(function()
        {
            if ($(this).attr("class") != active_tab_class)
            {
                var el = $(this).attr("id");
                setLinkHoverClass(el)
                return false;
            }
        });

        // navigation menu jump link mouseout
        $(navigation_menu_jump_link).mouseout(function()
        {
            if ($(this).attr("class") != active_tab_class)
            {
                var el = $(this).attr("id");
                clearLinkHoverClass(el)
                return false;
            }
        });

        //check if selected tab cookie exists - need to reshow it
        if ($.cookie(TAB_SELECTED) != null && $.cookie(TAB_SELECTED) != "null")
        {
            handleTabClick($("#" + $.cookie(TAB_SELECTED)), false, false);
        }
    }
});

//check to see whether cookies can be set
function cookieSetCheck()
{
    $.cookie(COOKIE_CHECK, "init", { expires: null, path: '/', domain: '.anglia.ac.uk' });

    if ($.cookie(COOKIE_CHECK) != null)
    {
        return true;
    }
    return false;
}

// set cookie value to visibility state of the menu
function setMenuHiddenCookie(state)
{
    $.cookie(SUB_MENU_HIDDEN, state, { expires: null, path: '/', domain: '.anglia.ac.uk' });
}

// update cookie with the value of the selected tab
function setTabSelectedCookie(tabId)
{
    $.cookie(TAB_SELECTED, tabId, { expires: null, path: '/', domain: '.anglia.ac.uk' });
}

// set css forthe currently active tab
function setActiveTabBg(tabId)
{
    $("#" + tabId).removeClass();
    $("#" + tabId + jump_link_suffix).removeClass();
    $("#" + tabId).addClass(active_tab_class);
    $("#" + tabId + jump_link_suffix).addClass(active_tab_class);
}

function clearActiveTabBg(tabId)
{
    $("#" + tabId).removeClass(active_tab_class);
    $("#" + tabId + "-jump-link").removeClass(active_tab_class);
}

// set hover state for em drop down controller
function setEmHoverClass(em)
{
    $("#" + em).addClass(navigation_menu_controller_hover);
    $("#" + em).parent().prevAll("a").addClass(navigation_menu_jump_link_hover);
}

// reset hover state for em drop down controller
function clearEmHoverClass(em)
{
    $("#" + em).removeClass(navigation_menu_controller_hover);
    $("#" + em).parent().prevAll("a").removeClass(navigation_menu_jump_link_hover);
}

// set hover state for link next to em ONLY
function setLinkHoverClass(lnk)
{
	if(lnk!="")
	{
	    $("#" + lnk).addClass(navigation_menu_jump_link_hover);
	    $("#" + lnk).nextAll("a").children("em").addClass(navigation_menu_controller_jump_link_hover);
	}
}

// reset hover state for link next to em ONLY
function clearLinkHoverClass(lnk)
{
	if(lnk!="")
	{
    $("#" + lnk).removeClass(navigation_menu_jump_link_hover);
    $("#" + lnk).nextAll("a").children("em").removeClass(navigation_menu_controller_jump_link_hover);
	}
}

// hide all menu containers
function hideAllSubmenuLinkContainers()
{
    $(navigation_submenu + " div").hide();
}

// display selected container
function displaySelectedSubmenuLinkContainer(id)
{
    hideAllSubmenuLinkContainers();
    var relatedMenuDiv = "#" + id + submenu_links_container_suffix;
    $(navigation_submenu_container).show();
    $(relatedMenuDiv).show();
}

// menu container slide up function 
function slideMenuUp()
{
    $(navigation_submenu).slideUp('normal');
    clearActiveTabBg(currentTab)
    setMenuHiddenCookie("true");
    setTabSelectedCookie(null)
}

// menu container slide down function 
function slideMenuDown()
{
    $(navigation_submenu).slideDown();
    setMenuHiddenCookie("false");
}

// menu container show function 
function showMenu()
{
    $(navigation_submenu).show();
    setMenuHiddenCookie("false");
}

// menu container hide function 
function hideMenu()
{
    $(navigation_submenu).hide();
    setMenuHiddenCookie("true");
}

// determine whether sub menu is hidden
function subMenuHidden()
{
    if ($.cookie(SUB_MENU_HIDDEN) == "true" || $.cookie(SUB_MENU_HIDDEN) == "init")
    {
        return true;
    }
    return false;
}

// // menu container toggle function
function toggleSubMenu()
{
    var currDisplay = $(navigation_submenu).css("display");

    if (currDisplay == "block")
    {
        slideMenuUp();
    }
    else
    {
        slideMenuDown();
    }
}

// main function that affects visibility of menus, sets cookie values etc
function handleTabClick(theObject, doSlide, userClick)
{
    // get value of tab from cookie
    currentTab = $.cookie(TAB_SELECTED);

    // object ID passed by event trigger
    var thisID = theObject.attr("id");

    // clear current tab active class
    clearActiveTabBg(currentTab);

    // set new tab active class
    setActiveTabBg(thisID);

    // set new tab cookie value
    setTabSelectedCookie(thisID);

    // Get the name of the clicked tab and use it to derive the name of the sub menu links container									
    // hide all DIVs then show the one clicked
    displaySelectedSubmenuLinkContainer(thisID);

    // boolean to determine whether to display the submenu or not
    var affectMenuDisplay = false;

    // if the user clicks the already active tab then just toggle the visibility of the sub menu
    if (userClick && thisID == currentTab)
    {
        toggleSubMenu();
    }

    // if the sub menu is on display then just load relevant content
    if (!subMenuHidden())
    {
        affectMenuDisplay = true;
    }

    // if the sub menu is hidden and a user clicks another tab then unhide it
    if ((subMenuHidden() && thisID != currentTab))
    {
        affectMenuDisplay = true;
    }

    if (affectMenuDisplay)
    {
        // check if menu has been hidden by user			
        if (doSlide)
        {
            slideMenuDown();
        }
        else
        {
            showMenu();
        }
    }
    //reset selected tab cookie
    // setTabSelectedCookie(thisID);
}