
export 
{ 
  getMesLetras, formatoDeFecha, dosDecimales,
  buscarToken, cantidadPorPagina
};

const getMesLetras = (mes: number): string => 
{
  let mesEnLetras = "";
  if (mes == 1) 
  {
    mesEnLetras = "ENERO";
  }
  if (mes == 2) 
  {
    mesEnLetras = "FEBRERO";
  }
  if (mes == 3) 
  {
    mesEnLetras = "MARZO";
  }

  if (mes == 4) 
  {
    mesEnLetras = "ABRIL";
  }
  if (mes == 5) 
  {
    mesEnLetras = "MAYO";
  }
  if (mes == 6) 
  {
    mesEnLetras = "JUNIO";
  }

  if (mes == 7) 
  {
    mesEnLetras = "JULIO";
  }
  if (mes == 8) 
  {
    mesEnLetras = "AGOSTO";
  }
  if (mes == 9) 
  {
    mesEnLetras = "SEPTIEMBRE";
  }

  if (mes == 10) 
  {
    mesEnLetras = "OCTUBRE";
  }
  if (mes == 11) 
  {
    mesEnLetras = "NOVIEMBRE";
  }
  if (mes == 12) 
  {
    mesEnLetras = "DICIEMBRE";
  }
  return mesEnLetras;
}


const formatoDeFecha = (campoFecha: any): string => 
{

  if (campoFecha == null)
  {
    return "";
  }

  let fechaString = new Date(campoFecha.toString());

  let mes = fechaString.getMonth() + 1;
  let dia = fechaString.getDate();

  let diaTxt = "";
  if (dia < 10)
  {
    diaTxt = "0" + dia;
  }
  else
  {
    diaTxt = "" + dia;
  }

  return diaTxt + " " + getMesLetras(mes) + " " + fechaString.getFullYear() + " ";

}


const dosDecimales = ( xnumber: number ): number => 
{
  return Number(xnumber.toFixed(2));
}


const buscarToken = (): string =>
{
  let tokenSesion: string = localStorage.getItem('token') || "";
  if( tokenSesion.length > 2 )
  {
    return "Bearer " + tokenSesion;
  }
  else
  {
    return "";
  }
}


const cantidadPorPagina = [1, 2, 50, 100, 200];

