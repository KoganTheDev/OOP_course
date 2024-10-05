# 🌍 Cities and Roads Simulation

## 📜 Overview
This project models a simulation of cities connected by roads, organized within countries. It provides classes to represent cities, roads, countries, and the world itself, along with methods for managing and retrieving information about them.

---

## 🏗️ Class Diagram

```plaintext
+----------------+          +----------------+
|    City        |          |   Road         |
+----------------+          +----------------+
| - name         |          | - city1        |
| - arr          |          | - city2        |
+----------------+          | - length       |
| + City(name)   |          +----------------+
| + connect()    |          | + getCity1()   |
| + numRoads()   |          | + getCity2()   |
| + nearestCity()|          | + getLength()  |
| + toString()   |          +----------------+
+----------------+          
        |
        |          
        |          
        |          
+----------------+          
|  Country       |          
+----------------+          
| - name         |          
| - cities       |          
+----------------+          
| + Country(name)|     
| + addCity()    |     
| + population() |     
| + smallCities()|     
| + report()     |     
+----------------+          
        |
        |          
        |          
        |          
+----------------+          
|    World       |          
+----------------+          
| - countries    |          
+----------------+          
| + addCountry() |          
| + addCity()    |          
| + population() |          
| + smallCities()|          
| + report()     |          
+----------------+          
