
export 
{ 
  getMesLetras, formatoDeFecha, dosDecimales,
  buscarToken, cantidadPorPagina, moneda,
  deshabilitarBoton
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



  let horass = fechaString.getHours();
  let horasTxt = "";
  if( horass < 10 ){
    horasTxt = "0" + horass;
  }
  else 
  {
    horasTxt = horass + "";
  }




  let minutoss = fechaString.getMinutes();
  let minutosTxt = "";
  if( minutoss < 10 ){
    minutosTxt = "0" + minutoss;
  }
  else 
  {
    minutosTxt = "" + minutoss;
  }




  let segundoss = fechaString.getSeconds();
  let segundosTxt = "";
  if( segundoss < 10 ){
    segundosTxt = "0" + segundoss;
  }
  else 
  {
    segundosTxt = "" + segundoss;
  }



  return diaTxt + " " + getMesLetras(mes) + " " + fechaString.getFullYear() + " " 
    + horasTxt + ":" + minutosTxt + ":" + segundosTxt;

}


const dosDecimales = ( xnumber: number ): number => 
{
  return Number(xnumber.toFixed(2));
}


const buscarToken = (): string =>
{
  // no funciona localStorage
  //let tokenSesion: string = localStorage.getItem('token') || "";
  return "Bearer ";
}

const deshabilitarBoton =  (idBoton:string): void => {
  let botonAnularPedido = document.getElementById(idBoton);
  botonAnularPedido?.setAttribute('disabled','');
}


const soloLectura =  (idBoton:string): void => {
  let objetoSeleccionado = document.getElementById(idBoton);
  objetoSeleccionado?.setAttribute('readonly','');
}


const cantidadPorPagina:number[] = [10, 50, 100, 150, 200, 250];

const moneda = 'Q. ';
