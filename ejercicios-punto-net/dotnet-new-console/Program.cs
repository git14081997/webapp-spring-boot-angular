
using System.Text.Json;

interface IShow
{
	public void show(string msg);
	public void verify();
};


class Venta : Claseprincipal, IShow
{
	public Venta(string nombre, double total) : base(nombre, total)
	{
	} // constructor 

	public string GetTotalWithTax()
	{
		double iva = this.Total * 0.12;
		this.Total = this.Total + iva;
		return this.Total.ToString();
	} // GetTotalWithTax 
	
	public void show( string msg )
	{
		System.Console.WriteLine(msg);
	} // msg 


	public void verify()
	{
		System.Console.WriteLine("el sistema está actualizado !");
	} // verify 

} // Venta 






class Claseprincipal
{

	public double Total { get; set; }
	public string Nombre { get; set; }
	public int Edad { get; set; }

	public Claseprincipal(string Nombre, double Total)
	{
		this.Total = Total;
		this.Nombre = Nombre;
		this.Edad = 0;
	} // main

	public double GetTotal()
	{
		this.Total += 1;
		return this.Total;
	} // GetTotal()

	public static void Main()
	{
		System.Console.WriteLine("Hola Mundo");
		System.Console.WriteLine("Hello, World!");

		Claseprincipal sale = new Claseprincipal( "Jenny", 0 );

		System.Console.WriteLine("Total: " + sale.Total.ToString() );
		System.Console.WriteLine("Nombre: " + sale.Nombre );

		sale.GetTotal();
		System.Console.WriteLine("Total: " + sale.Total.ToString() );

		sale.GetTotal();
		System.Console.WriteLine("Total: " + sale.Total.ToString() );



		Venta venta = new Venta("camisas", 199.99);

		System.Console.WriteLine(
			venta.GetTotalWithTax()
		);

		venta.show("saldo actualizado !");
		venta.verify();

		// objeto a json
		string objson = JsonSerializer.Serialize(venta);
		venta.show("objeto a json:");
		venta.show( objson );

		venta.show("json a objeto:");
		Venta ventaRecibidaDeJson = 
		JsonSerializer.Deserialize<Venta>(objson);
		venta.show( ventaRecibidaDeJson.Nombre );
		venta.show( ventaRecibidaDeJson.Total.ToString() );
		venta.show( ventaRecibidaDeJson.Edad.ToString() );



	} // main

} // Claseprincipal 


