<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>welcome</title>
</head>
<body>

<h1> CD LIST </h1>
<table>
    <tr>
        <th>Description</th>
        <th class="text-center">Price</th>
        <th>&nbsp;</th>
    </tr>
    <tr>
        <td>(Bohemia)Rooh</td>
        <td class="text-center">$14</td>
        <td><form action="cart" method="post">
            <input type="hidden" name="productCode" value="8601">
            <input type="submit" value="submit">
        </form>
        </td>
    </tr>
</table>
</body>
</html>
