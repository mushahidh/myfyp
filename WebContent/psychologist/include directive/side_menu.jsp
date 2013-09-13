
<div id="sidebar" class="">
  <div class="scrollbar">
    <div class="track">
      <div class="thumb">
        <div class="end"></div>
      </div>
    </div>
  </div>
  <div class="viewport ">
    <div class="overview collapse">
      <div class="search row-fluid container">
        <h2>ICGS Psychologist Panel</h2>
      
      </div>
      <ul id="sidebar_menu" class="navbar nav nav-list container full">
        <li class="accordion-group active color_24"> <a class="dashboard " href="../index/index.jsp"><img src="${pageContext.request.contextPath}/resources/img/menu_icons/dashboard.png"><span>Dashboard</span></a> </li>
       
        <li class="accordion-group color_24"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse1"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Interest</span></a>
           <ul id="collapse1" class="accordion-body collapse">
            <li><a href="../../interest_controller?user_action=add_interest">Add Interest</a></li>
            <li><a href="../../interest_controller?user_action=show_interest">Show Interest</a></li>
          </ul> 
        </li>
        <li class="accordion-group color_24"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse2"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Question</span></a>
          <ul id="collapse2" class="accordion-body collapse">
            <li><a href="../../question_controller?user_action=add_question">Add Question</a></li>
            <li><a href="../../question_controller?user_action=show_question">Show Question</a></li>

          </ul>
        </li>
		 <li class="accordion-group color_24"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse7"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/tables.png"><span>Manage Affect</span></a>
          <ul id="collapse7" class="accordion-body collapse">
            <li><a href="../../affect_controller?user_action=add_affect">Add Affect</a></li>
            <li><a href="../../affect_controller?user_action=show_affect">Show Affect</a></li>
          </ul>
        </li>
       
      </ul>
      <div class="menu_states row-fluid container ">
        <h2 class="pull-left">Menu Settings</h2>
        <div class="options pull-right">
          <button id="menu_state_1" class="color_24" rel="tooltip" data-state ="sidebar_icons" data-placement="top" data-original-title="Icon Menu">1</button>
          <button id="menu_state_2" class="color_24 active" rel="tooltip" data-state ="sidebar_default" data-placement="top" data-original-title="Fixed Menu">2</button>
          <button id="menu_state_3" class="color_24" rel="tooltip" data-placement="top" data-state ="sidebar_hover" data-original-title="Floating on Hover Menu">3</button>
        </div>
      </div>
      <!-- End sidebar_box --> 
      
    </div>
  </div>
</div>
