<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="shortcut icon" type="image/png" href="../img/noose.png"/>
    <title>Woordenlijst</title>
</head>
<body>
   <header>
       <ul>
           <li><a href="/html/Overview.html">Woordenlijst</a></li>
           <li><a href="/html/Home.html">Beheersapplicatie</a></li>
           <li><a href="/html/AddWoord.html">Woord toevoegen</a></li>
       </ul>
   </header>
   <main>
        <h1>Hangman management interface</h1>
        <h2>Woordenlijst</h2>
        <table>
        
        	<tr>
                <th>Woord</th>
                <th>Moeilijkheidsgraad</th>
            </tr>
        
        	<%ArrayList<String> woorden = (ArrayList<String>) request.getAttribute("woordenlijst");%>
        	<%For(String woord : woorden) {%>
        			<td><%= woord %></td>
        			<td> Moeilijk </td>
        	<%} %>
        	
        	
        	
            <!-- <tr>
                <th>Woord</th>
                <th>Moeilijkheidsgraad</th>
            </tr>
            <tr>
                <td>domain exception</td>
                <td>extreem</td>
            </tr>
            <tr>
                <td>domain exception</td>
                <td>extreem</td>
            </tr>
            <tr>
                <td>domain exception</td>
                <td>extreem</td>
            </tr>
            <tr>
                <td>domain exception</td>
                <td>extreem</td>
            </tr>
            <tr>
                <td>domain exception</td>
                <td>extreem</td>
            </tr>
            <tr>
                <td>domain exception</td>
                <td>extreem</td>
            </tr> -->
        </table>
        <a href="">Nieuw woord</a>
        <a href="">Download woordenlijst</a>
   </main>
    <footer>
       <p>Ontworpen door Bram, Dante, Emil, Louis, Nand en Elewout</p>
   </footer>
</body>
</html>