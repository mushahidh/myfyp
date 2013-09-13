
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
        <h2>ICGS Admin Panel</h2>
       
      </div>
      <ul id="sidebar_menu" class="navbar nav nav-list container full">
        <li class="accordion-group active color_4"> <a class="dashboard " href="../index/index.jsp"><img src="${pageContext.request.contextPath}/resources/img/menu_icons/dashboard.png"><span>Dashboard</span></a> </li>
       
        <li class="accordion-group color_7"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse1"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/user.png"><span>Manage Users</span></a>
           <ul id="collapse1" class="accordion-body collapse">
            <li><a href="../../user_controller?user_action=add_user">Add User</a></li>
            <li><a href="../../user_controller?user_action=show_user">Show User</a></li>
          </ul> 
        </li>
        <li class="accordion-group color_3"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse2"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Universities</span></a>
          <ul id="collapse2" class="accordion-body collapse">
            <li><a href="../../university_controller?user_action=add_uni">Add University</a></li>
            <li><a href="../../university_controller?user_action=show_uni">Show University</a></li>

          </ul>
        </li>
        <li class="accordion-group color_12"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse3"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Fields</span></a>
          <ul id="collapse3" class="accordion-body collapse">
            <li><a href="../../field_controller?user_action=add_field">Add Field</a></li>
            <li><a href="../../field_controller?user_action=show_field">Show Field</a></li>
          </ul>
        </li>
         <li class="accordion-group color_13"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse4"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Offerings</span></a>
          <ul id="collapse4" class="accordion-body collapse">
            <li><a href="../../offers_controller?user_action=add_offer">Add offer</a></li>
            <li><a href="../../offers_controller?user_action=show_offer">Show offer</a></li>
          </ul>
        </li>
         <li class="accordion-group color_14"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse5"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Courses</span></a>
          <ul id="collapse5" class="accordion-body collapse">
            <li><a href="../../course_controller?user_action=add_course">Add course</a></li>
            <li><a href="../../course_controller?user_action=show_course">Show course</a></li>
          </ul>
        </li>
        <li class="accordion-group color_15"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse6"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Eligibility</span></a>
          <ul id="collapse6" class="accordion-body collapse">
            <li><a href="../../eligibility_controller?user_action=add_elig">Add Eligibility</a></li>
            <li><a href="../../eligibility_controller?user_action=show_elig">Show Eligibility</a></li>
          </ul>
        </li>
         <li class="accordion-group color_16"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse7"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Include</span></a>
          <ul id="collapse7" class="accordion-body collapse">
            <li><a href="../../includes_controller?user_action=add_include">Add Include</a></li>
            <li><a href="../../includes_controller?user_action=show_include">Show Include</a></li>
          </ul>
        </li>
           <li class="accordion-group color_17"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse8"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Groups</span></a>
          <ul id="collapse8" class="accordion-body collapse">
            <li><a href="../../group_controller?user_action=add_group">Add Group</a></li>
            <li><a href="../../group_controller?user_action=show_group">Show Group</a></li>
          </ul>
        </li>
           <li class="accordion-group color_18"> <a class="accordion-toggle widgets collapsed" data-toggle="collapse" data-parent="#sidebar_menu" href="#collapse9"> <img src="${pageContext.request.contextPath}/resources/img/menu_icons/forms.png"><span>Manage Group Includes</span></a>
          <ul id="collapse9" class="accordion-body collapse">
            <li><a href="../../group_includes_controller?user_action=add_group_include">Add Group Includes</a></li>
            <li><a href="../../group_includes_controller?user_action=show_group_include">Show Group Includes</a></li>
          </ul>
        </li>
       
      </ul>
      <div class="menu_states row-fluid container ">
        <h2 class="pull-left">Menu Settings</h2>
        <div class="options pull-right">
          <button id="menu_state_1" class="color_4" rel="tooltip" data-state ="sidebar_icons" data-placement="top" data-original-title="Icon Menu">1</button>
          <button id="menu_state_2" class="color_4 active" rel="tooltip" data-state ="sidebar_default" data-placement="top" data-original-title="Fixed Menu">2</button>
          <button id="menu_state_3" class="color_4" rel="tooltip" data-placement="top" data-state ="sidebar_hover" data-original-title="Floating on Hover Menu">3</button>
        </div>
      </div>
      <!-- End sidebar_box --> 
      
    </div>
  </div>
</div>
