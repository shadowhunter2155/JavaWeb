<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User Form</title>
		<link rel="stylesheet" href="/JavaWeb/css/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/button-style.css">
		
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	    <script type="text/javascript">
	      google.charts.load('current', {'packages':['corechart', 'table']});
	      google.charts.setOnLoadCallback(drawChart);
	
	      function drawChart() {
	
	    	  var data = google.visualization.arrayToDataTable([
		          ['Salary', 'Salary per Month'],
		          <c:forEach varStatus="status" var="user" items="${ users }">
		          	['${ user.name }', ${ user.salary }],
		          </c:forEach>
		        ]);
	
	    	  var options = {
	    	          title: 'User Salary'
	    	       };
	    	
	    	      	var chartPie   = new google.visualization.PieChart(document.getElementById('piechart'));
	    	 		var chartBar   = new google.visualization.BarChart(document.getElementById('barchart'));
	    	        var chartCol   = new google.visualization.ColumnChart(document.getElementById('columnchart'));
	    	        var chartLine  = new google.visualization.LineChart(document.getElementById('linechart'));
	    	        
	    	        chartPie.draw(data, options);
	    	        chartBar.draw(data, options);
	    	        chartCol.draw(data, options);
	    	        chartLine.draw(data, options);
	    	        
	    	        drawTable();
	    	      }
	      function drawTable() {
	          var data = new google.visualization.DataTable();
	          data.addColumn('string', 'Name');
	          data.addColumn('number', 'Salary');
	          data.addColumn('boolean', 'Full Time Employee');
	          data.addRows([
	        	<c:forEach varStatus="status" var="user" items="${ users }">
	            	['${ user.name }',   {v:${ user.salary }},  true],
	            </c:forEach>
	          ]);
	          	          	          
	          var table = new google.visualization.Table(document.getElementById('tablechart'));
				
	          table.draw(data, {showRowNumber: true});
	        }
	      
	      </script>


	</head>
	<body style="padding: 0px">
		<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 50 1440 120"><path fill="#0099ff" fill-opacity="0.6" d="M0,160L60,138.7C120,117,240,75,360,80C480,85,600,139,720,144C840,149,960,107,1080,101.3C1200,96,1320,128,1380,144L1440,160L1440,0L1380,0C1320,0,1200,0,1080,0C960,0,840,0,720,0C600,0,480,0,360,0C240,0,120,0,60,0L0,0Z"></path></svg>

		<div style="padding: 40px">
			
			<table>
				<tr>
					<!-- User Form -->
					<td valign="top">
						<form class="pure-form" method="POST" action="/JavaWeb/rest/user/${ id }">
							<fieldset>
								<legend>User Form</legend>
								序號: <input type="text" id="id" name="id" value="${ id }" readonly><p>
								姓名: <input type="text" placeholder="請輸入姓名" id="name" name="name" value="${ user.name }" required><p>
								薪資: <input type="number" placeholder="請輸入薪資" id="salary" name="salary" value="${ user.salary }" required><p>
								<input type="hidden" readonly name="_method" value="${ _method }"><p>
								<button type="button"
									onclick="location.href='/JavaWeb/rest/user/'" 
									class="pure-button button-secondary">RESET</button>
								<button type="submit" class="pure-button button-success">${ _method }</button>
							</fieldset>
						</form>
					</td>
					<!-- User List -->
					<td valign="top">
						<form class="pure-form">
							<fieldset>
								<legend>User List</legend>
								<table class="pure-table pure-table-bordered">
									<thead>
										<tr>
											<th>ID</th><th>Name</th><th>Salary</th><th>Update</th><th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach varStatus="status" var="user" items="${ users }">
											<tr>
												<td>${ status.index }</td>
												<td>${ user.name }</td>
												<td>${ user.salary }</td>
												<td title="修改" style="cursor: pointer;">
													<a href="/JavaWeb/rest/user/${ status.index }">
														<svg xmlns="http://www.w3.org/2000/svg" width="48" height="16" viewBox="0 0 20 20"><path d="M0 0h24v24H0z" fill="none"/><path d="M9 16.2l3 3.01V22h-6v-2.79l3-3.01zM12 3c-4.41 0-8 3.59-8 8s3.59 8 8 8 8-3.59 8-8-3.59-8-8-8zm0 14c-3.31 0-6-2.69-6-6s2.69-6 6-6 6 2.69 6 6-2.69 6-6 6z"/></svg></td>
													</a>
												<td title="刪除" style="cursor: pointer;">
													<a href="/JavaWeb/rest/user/${ status.index }?delete=true">
														<svg xmlns="http://www.w3.org/2000/svg" width="48" height="16" viewBox="0 0 20 20"><path d="M0 0h24v24H0z" fill="none"/><path d="M7 8v11c0 .55.45 1 1 1h8c.55 0 1-.45 1-1V8H7zm2-6h6l1.48 2H8.52L9 2zm9 6H6v-2h12v2z"/></svg></td>
													</a>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</fieldset>
						</form>
						<p>
						<div id="tablechart" style="width: 400px; height: 300px;"></div>
						
					</td>
					<!-- User Chart -->
					<td valign="top">
						<form class="pure-form">
							<fieldset>
								<legend>User Chart</legend>
								
								<table>
									<tr>
										<td><div id="piechart" style="width: 400px; height: 300px;"></div></td>
										<td><div id="barchart" style="width: 400px; height: 300px;"></div></td>
									</tr>
									<tr>
										<td><div id="columnchart" style="width: 400px; height: 300px;"></div></td>
										<td><div id="linechart" style="width: 400px; height: 300px;"></div></td>
									</tr>
								</table>
								
							</fieldset>
						</form>
					</td>
				</tr>
			</table>					
		</div>
	</body>
</html>