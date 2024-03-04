#!/bin/bash
dotnet tool install -g Microsoft.dotnet-httprepl
httprepl https://localhost:{PORT}
echo ls
echo cd something
echo get
echo exit
exit 0;
