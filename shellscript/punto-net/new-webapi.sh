#!/bin/bash

NOMBRE_PROYECTO="proyecto0"
mkdir -p $NOMBRE_PROYECTO;
cd $NOMBRE_PROYECTO;

dotnet new webapi -controllers -f net8.0
exit 0;
