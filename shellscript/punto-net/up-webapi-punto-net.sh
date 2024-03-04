#!/bin/bash
cd $1
dotnet build
# dotnet run
dotnet run --launch-profile https
exit 0;
