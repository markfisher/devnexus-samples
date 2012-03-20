<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Travel Demo: Search Results</title>
</head>
<body>
<h1>
	Hello Joe  
</h1>

<P>Choose from these:</P>

<form action="book" method="post">
	<input type="hidden" name="username" value="joe"/>
	<input type="hidden" name="zip" value="${zip}"/>
	<input type="hidden" name="startDate" value="${startDate}"/>
	<input type="hidden" name="endDate" value="${endDate}"/>
	Flight:
	<select name="flightNumber">
		<option value="FC123">First Class Airlines: 123</option>
		<option value="CC456">Cramped Cabin Air: 456</option>
	</select>
	Seat:
	<select name="seatNumber">
		<option>1A</option>
		<option>37E</option>
	</select>
	<br/>
	Hotel:
	<select name="hotelName">
		<option>Cheap Inn</option>
		<option>Luxury Suites</option>
		<option>Roach Motel</option>
	</select>
	Room:
	<select name="roomNumber">
		<option>103</option>
		<option>1207</option>
	</select>
	<br/>
	Car Size:
	<select name="carSize">
		<option>economy</option>
		<option>compact</option>
		<option>intermediate</option>
		<option>luxury</option>
	</select>
	Rental Agency:
	<select name="rentalAgency">
		<option>Lemons R'Us</option>
		<option>Quality Cars</option>
	</select>
	<input type="submit" value="Book"/>
</form>

</body>
</html>
