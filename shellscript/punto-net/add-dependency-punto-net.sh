#!/bin/bash

# dependencias minimas necesarias
dotnet add package Microsoft.EntityFrameworkCore.Tools
dotnet add package Microsoft.EntityFrameworkCore.Sqlserver

# agregar documentación automatica SWAGGER
dotnet add package Swashbuckle.AspNetCore --version 6.1.4
dotnet add package Swashbuckle.AspNetCore --version 6.5.0


# otras dependencias
dotnet add package Microsoft.VisualStudio.Web.CodeGeneration.Design
dotnet add package Microsoft.EntityFrameworkCore.Design
dotnet tool uninstall -g dotnet-aspnet-codegenerator
dotnet tool install -g dotnet-aspnet-codegenerator
dotnet tool update -g dotnet-aspnet-codegenerator



# similar a postman, pero de microsoft
dotnet tool install -g Microsoft.dotnet-httprepl
httprepl https://localhost:{PORT}


exit 0;
