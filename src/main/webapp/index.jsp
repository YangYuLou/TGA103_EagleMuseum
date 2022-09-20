<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Home</title>
		</head>
		<body>
			<form action="/TGA103_EagleMuseum/member/register" method="post">
				<label for="memberEmail">Email: </label>
				<input type="text" id="memberEmail" name="memberEmail">
				<br>
				<label for="memberPassword">Password: </label>
				<input type="password" id="memberPassword" name="memberPassword">
				<br>
				<label for="memberName">Name: </label>
				<input type="text" id="memberName" name="memberName">
				<br>
				<label for="memberQA">QA: </label>
				<input type="text" id="memberQA" name="memberQA">
				<br>
				<label for="memberAns">Ans: </label>
				<input type="text" id="memberAns" name="memberAns">
				<br>
				<label for="memberAddress">Address: </label>
				<input type="text" id="memberAddress" name="memberAddress">
				<br>
				<label for="memberPhone">Phone: </label>
				<input type="text" id="memberPhone" name="memberPhone">
				<br>
				<label for="memberGender">Gender: </label>
				<input type="text" id="memberGender" name="memberGender">
				<br>
				<label for="memberBirthday">Birthday: </label>
				<input type="text" id="memberBirthday" name="memberBirthday">
				<br>
				<label for="memberPermission">Permission: </label>
				<input type="text" id="memberPermission" name="memberPermission">
				<br>
				<input type="submit" value="Register">
				
			</form>
			<div>${result}</div>
			<hr>
			<table border="1">
				<thead>
					<tr>
						<th>memberID</th>
						<th>memberEmail</th>
						<th>memberPassword</th>
						<th>memberName</th>
						<th>memberQA</th>
						<th>memberAns</th>
						<th>memberAddress</th>
						<th>memberPhone</th>
						<th>memberGender</th>
						<th>memberBirthday</th>
						<th>memberPermission</th>
						<th>modifyTime</th>
						<th>lastEnterTime</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${memberList}">
						<tr>
							<td>${member.memberID}</td>
							<td>${member.memberEmail}</td>
							<td>${member.memberPassword}</td>
							<td>${member.memberName}</td>
							<td>${member.memberQA}</td>
							<td>${member.memberAns}</td>
							<td>${member.memberAddress}</td>
							<td>${member.memberPhone}</td>
							<td>${member.memberGender}</td>
							<td>${member.memberBirthday}</td>
							<td>${member.memberPermission}</td>
							<td>${member.modifyTime}</td>
							<td>${member.lastEnterTime}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</body>
		</html>