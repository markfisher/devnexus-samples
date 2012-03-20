<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Travel Demo: Home</title>
</head>
<body>

<h3>Current Itineraries:</h3>
<ul>
  <c:forEach var="itinerary" items="${itineraries}">
    <li>
      <b>Itinerary ID ${itinerary.id}: from ${itinerary.startDate} to ${itinerary.endDate}</b>
      <ul>
        <li>flight: ${itinerary.flightReservation}</li>
        <li>hotel: ${itinerary.hotelReservation}</li>
        <li>car: ${itinerary.carReservation}</li>
      </ul>
    </li>
  </c:forEach>
</ul>

<hr/>
<p>Book Another Trip:</p>
<form action="search" method="post">
	Zip: <input type="text" name="zip"/>
	<br/>
	Start: <input type="text" name="startDate"/>
	<br/>
	End: <input type="text" name="endDate"/>
	<br/>
	<input type="submit" value="Search"/>
</form>

</body>
</html>
