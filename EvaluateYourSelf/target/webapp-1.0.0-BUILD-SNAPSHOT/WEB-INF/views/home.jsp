<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
  <head>
    <base href="/">
    <title>Evaluate YourSelf</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- STYLES -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/webclient/styles.css">

    
    <!-- 1. Load libraries -->
     <!-- Polyfill(s) for older browsers -->
    <script src="/resources/webclient/node_modules/core-js/client/shim.min.js"></script>
    <script src="/resources/webclient/node_modules/zone.js/dist/zone.js"></script>
    <script src="/resources/webclient/node_modules/reflect-metadata/Reflect.js"></script>
    <script src="/resources/webclient/node_modules/systemjs/dist/system.src.js"></script>
    <!-- 2. Configure SystemJS -->
    <script src="/resources/webclient/systemjs.config.js"></script>
    <script>
      System.import('app').catch(function(err){ console.error(err); });
    </script>
  </head>
  <!-- 3. Display the application -->
  <body>
    <app-root><app-root>
  </body>
</html>