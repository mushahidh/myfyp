<%@ page import="bean.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="database.*" %>
<!DOCTYPE html>
<html class="sidebar_hover  no-js" lang="en">
<head>
<meta charset="utf-8">
<title>ICGS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/css/images/favicon.png">
<!-- Le styles -->
<link href="${pageContext.request.contextPath}/resources/css/twitter/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/twitter/responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.23.custom.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/plugins/modernizr.custom.32549.js"></script>
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="/../../../html5shim.googlecode.com/svn/trunk/html5.js"></script>
      <![endif]-->
</head>

<body>
<div id="loading"><img src="${pageContext.request.contextPath}/resources/img/ajax-loader.gif"></div>
<div id="responsive_part">
  <div class="logo"> <a href="index.html"><span>Start</span><span class="icon"></span></a> </div>
  <ul class="nav responsive">
    <li>
      <button class="btn responsive_menu icon_item" data-toggle="collapse" data-target=".overview"> <i class="icon-reorder"></i> </button>
    </li>
  </ul>
</div>
<!-- Responsive part -->
 <%@ include file="../include directive/side_menu.jsp" %>
<div id="main">
  <div class="container">
    <div class="header row-fluid">
     <%@ include file="../include directive/header.jsp" %>
    
      <div class="top_right">
        <ul class="nav nav_menu">
          <li class="dropdown"> <a class="dropdown-toggle administrator" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="../../page.html">
         <%@include file="../include directive/screen_name.jsp" %></a>
          <%@include file="../include directive/logout.jsp" %>
          </li>
        </ul>
      </div>
      <!-- End top-right --> 
    </div>
    <div id="main_container">
      <div class="row-fluid">
        <div class="span6 box color_3 title_big height_big paint_hover">
          <div class="title">
            <div class="row-fluid">
              <div class="span12">
                <h4> </i><span>Campaigns</span> </h4>
              </div>
              <!-- End .span12 --> 
            </div>
            <!-- End .row-fluid --> 
            
          </div>
          <!-- End .title -->
          <div class="content"  style="padding-top:35px;">
            <div id="placeholder" style="width:100%;height:240px;"> </div>
          </div>
        </div>
        <!-- End .box .span6-->
        <div class="span6">
          <div class="row-fluid fluid">
            <div class="span6">
              <div class=" box color_2 height_medium paint_hover">
                <div class="content numbers">
                  <%
			audience_reachDAO AR=new audience_reachDAO();
            audience_reach ar=new audience_reach();
			
			ar=AR.retrieveAudience_reachInfo();
			
		%>
                  <h3 class="value"><%=ar.getAudience_reach() %></h3>
                  <div class="description mb5">Audience Reach</div>
                  <h1 class="value"><%=ar.getCtr_average() %><span class="percent">%</span></h1>
                  <div class="description">Average CTR</div>
                </div>
              </div>
            </div>
            <!-- End .span6 -->
            <div class="span6">
              <div class="box color_25 height_medium paint_hover">
                <div class="content numbers">
                         <%
								total_clicksDAO TC=new total_clicksDAO();
					            total_clicks tc=new total_clicks();
								tc=TC.retrieveTotal_clicksInfo();
								
						%>
                  <h3 class="value"><%=tc.getTotal_clicks() %></h3>
                  <div class="description mb5">Total Clicks</div>
                  <h1 class="value"><%=tc.getTotal_impressions() %></h1>
                  <div class="description">Total Impressions</div>
                </div>
              </div>
            </div>
            <!-- End .span6 --> 
          </div>
          <!-- End .row-fluid -->
          <div class="row-fluid fluid">
            <div class="span6">
              <div class=" box  height_medium title_big paint_hover">
                <div class="title">
                  <div class="row-fluid">
                    <div class="span12">
                      <h5> </i><span>Fundraisers</span> </h5>
                    </div>
                    <!-- End .span12 --> 
                  </div>
                  <!-- End .row-fluid --> 
                </div>
                <!-- End .title -->
                <div class="content" style="padding-top:28px;">
                  <div id="placeholder2" style="width:100%;height:85px;"></div>
                  <div class="row-fluid description">
                    <div class="pull-left">LAST 30 DAYS</div>
                    <div class="pull-right">TODAY</div>
                  </div>
                </div>
              </div>
            </div>
            <!-- End .span6 -->
          <div class="span6">
              <div class=" box color_26 height_medium paint_hover">
                <div class="content icon big_icon"> <a href="#" ><img align="center" src="../../resources/img/general/contacts_icon.png" /></a>
                  <div class="description">CONTACTS</div>
                </div>
              </div>
            </div>
            <!-- End .span6 --> 
          </div>
          <!-- End .row-fluid --> 
          
        </div>
        <!-- End.span6--> 
      </div>
      <!-- End .row-fluid -->
      
      <div class="row-fluid">
        <div class="span8">
          <div class="box height_big paint">
            <div class="title">
              <h4> <span>Distribution by Cities</span> </h4>
            </div>
            <!-- End .title -->
            <div class="content full">
              <table id="datatable_example" class="responsive table table-hover full">
                <thead>
                  <tr>
                    <th class="jv no_sort"> No </th>
                    <th class="ue"> Location </th>
                    <th class="ms no_sort "> Visits </th>
                    <th class="Yy to_hide_phone"> % Visits </th>
                  </tr>
                </thead>
                <%
					top_user_citiesDAO TUC=new top_user_citiesDAO();
                	top_user_cities tuc=new top_user_cities();
					ArrayList<top_user_cities> TUCI=new ArrayList<top_user_cities>();
					TUCI=TUC.retrieveTop_user_citiesInfo();
					int j=0;
				%>
                <tbody>
                <%while(j<TUCI.size()) 
                {
                	tuc=(top_user_cities)TUCI.get(j);
                
                %>
                  <tr>
                    <td> <%=j+1 %> </td>
                    <td><%=tuc.getLocation() %> </td>
                    <td class="ms"><%=tuc.getVisits() %> </td>
                    <td class="to_hide_phone"><%=tuc.getVisits_percentage()%> </td>
                  </tr>
                 <%j=j+1;} %>
                </tbody>
              </table>
            </div>
            <!-- End .content -->
            <div class="description">Some explanation text here <i class="gicon-info-sign icon-white"></i></div>
          </div>
          
          <!-- End .box --> 
        </div>
        <!-- End .span8 -->
        
        <div class="span4">
          <div class="box height_big paint">
            <div class="title">
              <h4> <span>Top Users</span> </h4>
            </div>
            <!-- End .title -->
            
            <ul class="users unstyled content">
              <%
					top_userDAO TU=new top_userDAO();
                	top_user tu=new top_user();
					ArrayList<top_user> TUI=new ArrayList<top_user>();
					TUI=TU.retrieveTop_userInfo();
					int k=0;
				%>
				<%
				while(k<TUI.size())
					
				{	
					tu=(top_user)TUI.get(k);	
				%>
              <li>
                <div class="info row-fluid"><span class="number pull-left text_color_0"><%=k+1 %></span>
                  <h2 class="pull-left"><%=tu.getUser_name() %></h2>
                </div>
                <div class="row-fluid">
                  <div class="progress small" style="width:<%=tu.getTotal_percentage()%>%;"></div>
                  <div class="value"><%=tu.getUser_clicks() %>Reach</div>
                </div>
              </li>
             <%k=k+1;} %>
            </ul>
            <!-- End .content -->
            <div class="description">Some explanation text here <i class="gicon-info-sign icon-white"></i> </div>
          </div>
          <!-- End .box --> 
        </div>
        <!-- End .span4 --> 
      </div>
      <!-- End .row-fluid -->
      
      <div class="row-fluid"><!-- End .box --> 
        
      </div>
      <!-- End .row-fluid -->
      
    
      <!-- End .row-fluid -->
      
        <!-- End .span6 -->
        <div class="span6">
          <div class="box color_2 ">
            <div class="title row-fluid">
            <h4 class="pull-left"><span>FeedBack</span></h4>
              <div class="btn-toolbar pull-right ">
                <div class="btn-group"> <a class="btn">View All</a> <a class="btn change_color_outside"><i class="paint_bucket"></i></a> </div>
              </div>
            </div>
            <!-- End .title -->
            <div class="content row-fluid">
              <ul class="messages_layout">
              <%
					admin_feedbackDAO AFD=new admin_feedbackDAO();
              		admin_feedback af=new admin_feedback();
					ArrayList<admin_feedback> AFI=new ArrayList<admin_feedback>();
					AFI=AFD.retrieveAdmin_feedbackInfo();
					int m=0;
				
				while(m<AFI.size())
						
				{
					af=(admin_feedback)AFI.get(m);
				%>
                <li class="from_user left"> <a href="#" class="avatar"><img src="${pageContext.request.contextPath}/resources/img/message_avatar2.png"/></a>
                  <div class="message_wrap"> <span class="arrow"></span>
                    <div class="info"> <a class="name"><%=af.getUser_name() %></a> <span class="time">1 hour ago</span>
                    
                    </div>
                    <div class="text"> <%=af.getUser_message() %></div>
                  </div>
                </li>
                <%m=m+1;} %>
               
              </ul>
            </div>
            <!-- End .content --> 
          </div>
          <!-- End .box --> 
        </div>
        <!-- End .span6 --> 
        
      </div>
      <!-- End .row-fluid --> 
    </div>
    <!-- End #container --> 
  </div>
  <div id="footer">
    <p> &copy; Copyrights ICGS 2013 </p>
    <span class="company_logo"><a href="../../../www.pixelgrade.com/default.htm"></a></span> </div>
</div>
<div class="background_changer dropdown">
  <div class="dropdown" id="colors_pallete"> <a data-toggle="dropdown" data-target="drop4" class="change_color"></a>
    <ul  class="dropdown-menu pull-left" role="menu" aria-labelledby="drop4">
      <li><a data-color="color_0" class="color_0" tabindex="-1">1</a></li>
      <li><a data-color="color_1" class="color_1" tabindex="-1">1</a></li>
      <li><a data-color="color_2" class="color_2" tabindex="-1">2</a></li>
      <li><a data-color="color_3" class="color_3" tabindex="-1">3</a></li>
      <li><a data-color="color_4" class="color_4" tabindex="-1">4</a></li>
      <li><a data-color="color_5" class="color_5" tabindex="-1">5</a></li>
      <li><a data-color="color_6" class="color_6" tabindex="-1">6</a></li>
      <li><a data-color="color_7" class="color_7" tabindex="-1">7</a></li>
      <li><a data-color="color_8" class="color_8" tabindex="-1">8</a></li>
      <li><a data-color="color_9" class="color_9" tabindex="-1">9</a></li>
      <li><a data-color="color_10" class="color_10" tabindex="-1">10</a></li>
      <li><a data-color="color_11" class="color_11" tabindex="-1">10</a></li>
      <li><a data-color="color_12" class="color_12" tabindex="-1">12</a></li>
      <li><a data-color="color_13" class="color_13" tabindex="-1">13</a></li>
      <li><a data-color="color_14" class="color_14" tabindex="-1">14</a></li>
      <li><a data-color="color_15" class="color_15" tabindex="-1">15</a></li>
      <li><a data-color="color_16" class="color_16" tabindex="-1">16</a></li>
      <li><a data-color="color_17" class="color_17" tabindex="-1">17</a></li>
      <li><a data-color="color_18" class="color_18" tabindex="-1">18</a></li>
      <li><a data-color="color_19" class="color_19" tabindex="-1">19</a></li>
      <li><a data-color="color_20" class="color_20" tabindex="-1">20</a></li>
      <li><a data-color="color_21" class="color_21" tabindex="-1">21</a></li>
      <li><a data-color="color_22" class="color_22" tabindex="-1">22</a></li>
      <li><a data-color="color_23" class="color_23" tabindex="-1">23</a></li>
      <li><a data-color="color_24" class="color_24" tabindex="-1">24</a></li>
      <li><a data-color="color_25" class="color_25" tabindex="-1">25</a></li>
    </ul>
  </div>
</div>
<!-- End .background_changer -->
</div>
<!-- /container --> 

<!-- Le javascript
    ================================================== --> 
<!-- General scripts --> 
<script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"> </script> 
<script src="${pageContext.request.contextPath}/resources/js/plugins/enquire.min.js" type="text/javascript"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery.sparkline.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/plugins/excanvas.compiled.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-transition.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-alert.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-modal.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-dropdown.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-scrollspy.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tab.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tooltip.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-popover.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-button.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-collapse.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-carousel.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-typeahead.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-affix.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/fileinput.jquery.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.23.custom.min.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/jquery.touchdown.js" type="text/javascript"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery.uniform.min.js"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery.tinyscrollbar.min.js"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jnavigate.jquery.min.js"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.touchSwipe.min.js"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery.peity.min.js"></script> 

<!-- Flot charts --> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/flot/jquery.flot.js"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/flot/jquery.flot.stack.js"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/flot/jquery.flot.pie.js"></script> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/flot/jquery.flot.resize.js"></script> 

<!-- Data tables --> 
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/plugins/datatables/js/jquery.dataTables.js"></script> 

<!-- Task plugin --> 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/knockout-2.0.0.js"></script> 

<!-- Custom made scripts for this template --> 
<script src="${pageContext.request.contextPath}/resources/js/scripts.js" type="text/javascript"></script> 
<script type="text/javascript">
  /**** Specific JS for this page ****/
/* Todo Plugin */
var data = [
{id: 1, title: "<i class='gicon-gift icon-white'><\/i>Have tea with the Queen", isDone: false},
{id: 2, title: "<i class='gicon-briefcase icon-white'><\/i>Steal  James Bond car", isDone: true},
{id: 3, title: "<i class='gicon-heart icon-white'><\/i>Confirm that this template is awesome", isDone: false},
{id: 4, title: "<i class='gicon-thumbs-up icon-white'><\/i>Nothing", isDone: false},  
{id: 5, title: "<i class='gicon-fire icon-white'><\/i>Play solitaire", isDone: false}         
];


function Task(data) {
  this.title = ko.observable(data.title);
  this.isDone = ko.observable(data.isDone);
  this.isEditing = ko.observable(data.isEditing);

  this.startEdit = function (event) {
      console.log("editing");
      this.isEditing(true);
  }

  this.updateTask = function (task) {
      this.isEditing(false);
  }
}

function TaskListViewModel() {
          // Data
          var self = this;
          self.tasks = ko.observableArray([]);
          self.newTaskText = ko.observable();
          self.incompleteTasks = ko.computed(function() {
              return ko.utils.arrayFilter(self.tasks(), 
                function(task) { 
                  return !task.isDone() && !task._destroy;
              });
          });

          self.completeTasks = ko.computed(function(){
              return ko.utils.arrayFilter(self.tasks(), 
                function(task) { 
                  return task.isDone() && !task._destroy;
              });
          });

          // Operations
          self.addTask = function() {
              self.tasks.push(new Task({ title: this.newTaskText(), isEditing: false }));

              self.newTaskText("");

          };
          self.removeTask = function(task) { self.tasks.destroy(task) };

          self.removeCompleted = function(){
              self.tasks.destroyAll(self.completeTasks());
          };

          /* Load the data */
          var mappedTasks = $.map(data, function(item){
              return new Task(item);
          });

          self.tasks(mappedTasks);      
      }

      ko.applyBindings(new TaskListViewModel());  
      //End Todo Plugin

      </script><script type="text/javascript">
      //Chart - Campaigns
      $(function () {
    	  <%
			campaignDAO CD=new campaignDAO();
			campaign c=new campaign();
			ArrayList<campaign> CA=new ArrayList<campaign>();
			CA=CD.retrieveCampaignInfo();
			int i=0;
		%>
        var d4 = [<% while(i<CA.size()){c=(campaign)CA.get(i);if(i+1!=CA.size()){%>[<%=c.getNumber()%>,<%=c.getBar()%>],<%}else{ %>[<%=c.getNumber()%>,<%=c.getBar()%>] <%}i=i+1;} %>];
        var d5 = [[1,12], [2,10], [3,9], [4,8], [5,8], [6,8], [7,8], [8,8],[9,9],[10,9],[11,10],[12,11],[13,12],[14,11],[15,10],[16,10],[17,9],[18,10],[19,11],[20,11],[21,12],[22,13],[23,14],[24,13],[25,12],[25,12],[26,11],[27,10],[28,9],[29,8],[30,7],[31,7], [32,8], [33,8], [34,7], [35,6], [36,6], [37,7], [38,8],[39,8],[40,9],[41,10],[42,11],[43,11],[44,12],[45,12],[46,11],[47,10],[48,9],[49,8],[50,8],[51,9], [52,10], [53,11], [54,12], [55,12], [56,12], [57,13], [58,13],[59,12],[60,11],[61,10],[62,9],[63,8],[64,7],[65,7],[66,6],[67,5],[68,4],[69,3]];

        var plot = $.plot($("#placeholder"),
            [ { data: d4, color:"rgba(0,0,0,0.2)", shadowSize:0, 
            bars: {
              show: true,
              lineWidth: 0,
              fill: true,

              fillColor: { colors: [ { opacity: 1 }, { opacity: 1 } ] },
          }
      } , 
      { data: d5, 

          color:"rgba(255,255,255, 0.4)", 
          shadowSize:0,
          lines: {show:true, fill:false}, points: {show:false},
          bars: {show:false},
      },  
      ],     
      {
        series: {
         bars: {show:true, barWidth: 0.6}
     },
     grid: { show:false, hoverable: true, clickable: false, autoHighlight: true, borderWidth:0,   },
     yaxis: { min: 0, max: 20 },

 });

        function showTooltip(x, y, contents) {
            $('<div id="tooltip"><div class="date">12 Nov 2012<\/div><div class="title text_color_3">'+x/10+'%<\/div> <div class="description text_color_3">CTR<\/div><div class="title ">'+x*12+'<\/div><div class="description">Impressions<\/div><\/div>').css( {
                position: 'absolute',
                display: 'none',
                top: y - 125,
                left: x - 40,
                border: '0px solid #ccc',
                padding: '2px 6px',
                'background-color': '#fff',
                opacity: 10
            }).appendTo("body").fadeIn(200);
        }

        var previousPoint = null;
        $("#placeholder").bind("plothover", function (event, pos, item) {
            $("#x").text(pos.x.toFixed(2));
            $("#y").text(pos.y.toFixed(2));
            if (item) {
                if (previousPoint != item.dataIndex) {
                  previousPoint = item.dataIndex;
                  $("#tooltip").remove();
                  var x = item.datapoint[0].toFixed(2),
                  y = item.datapoint[1].toFixed(2);
                  showTooltip(item.pageX, item.pageY,
                    x);
              }
          }
      });

         //Fundraisers chart
         	  <%
			fundraiserDAO FD=new fundraiserDAO();
			fundraiser f=new fundraiser();
			ArrayList<fundraiser> FA=new ArrayList<fundraiser>();
			FA=FD.retrieveFundraiserInfo();
			int fr=0;
		%>
         var d6 = [<% while(fr<FA.size()){f=(fundraiser)FA.get(fr);if(fr+1!=FA.size()){%>[<%=f.getNumber()%>,<%=f.getBar()%>],<%}else{ %>[<%=f.getNumber()%>,<%=f.getBar()%>] <%}fr=fr+1;} %>];
         $.plot($("#placeholder2"),
           [ { data: d6, color:"#fff", shadowSize:0, 
           bars: {
              show: true,
              lineWidth: 0,
              fill: true,
              highlight: {
                opacity: 0.3
            },
            fillColor: { colors: [ { opacity: 1 }, { opacity: 1 } ] },
        },
    } , 
    ],     
    {
       series: {
         bars: {show:true, barWidth: 0.6}
     },
     grid: { show:false, hoverable: true, clickable: false, autoHighlight: true, borderWidth:0,   },
     yaxis: { min: 0, max: 23 },

 });

         function showTooltip2(x, y, contents) {
          $('<div id="tooltip"><div class="title ">'+x*2+'</div><div class="description">Impressions</div></div>').css( {
            position: 'absolute',
            display: 'none',
            top: y - 58,
            left: x - 40,
            border: '0px solid #ccc',
            padding: '2px 6px',
            'background-color': '#fff',
            opacity: 10
        }).appendTo("body").fadeIn(200);
      }

      var previousPoint = null;
      $("#placeholder2").bind("plothover", function (event, pos, item) {
          $("#x").text(pos.x.toFixed(2));
          $("#y").text(pos.y.toFixed(2));
          if (item) {
            if (previousPoint != item.dataIndex) {
              previousPoint = item.dataIndex;
              $("#tooltip").remove();
              var x = item.datapoint[0].toFixed(2),
              y = item.datapoint[1].toFixed(2);
              showTooltip2(item.pageX, item.pageY,
                x);
          }
      }
  });
    //Envato chart
    $.plot($("#placeholder3"),
       [ { data: d6, color:"rgba(0,0,0,0.2)", shadowSize:0, 
       bars: {

          lineWidth: 0,
          fill: true,

          fillColor: { colors: [ { opacity: 1 }, { opacity: 1 } ] },
      },
      lines: {show:false, fill:true}, points: {show:false},
  } , 
  ],     
  {
   series: {
     bars: {show:true, barWidth: 0.6}
 },
 grid: { show:false, hoverable: true, clickable: false, autoHighlight: true, borderWidth:0,   },
 yaxis: { min: 0, max: 23 },

});
    //Facebook chart
    $.plot($("#placeholder4"),
       [ { data: d6, color:"rgba(0,0,0,0.2)", shadowSize:0, 
       bars: {

          lineWidth: 0,
          fill: true,

          fillColor: { colors: [ { opacity: 1 }, { opacity: 1 } ] },
      },
      lines: {show:false, fill:true}, points: {show:false},
  } , 
  ],     
  {
   series: {
     bars: {show:true, barWidth: 0.6}
 },
 grid: { show:false, hoverable: true, clickable: false, autoHighlight: true, borderWidth:0,   },
 yaxis: { min: 0, max: 23 },

});
    // End Fundraiser chart
});




</script>
</body>
</html>