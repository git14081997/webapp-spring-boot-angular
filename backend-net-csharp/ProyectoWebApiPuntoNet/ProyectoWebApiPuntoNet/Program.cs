

// continuar
// CODE FIRST con Entity Framework en .NET
// hdeleon.net
// https://www.youtube.com/watch?v=x1zjZUZJ6UA
// 12:03



using Microsoft.EntityFrameworkCore;
using ProyectoWebApiPuntoNet.DBContext;


namespace ProyectoWebApiPuntoNet
{


	public class Program
	{


		public static void Main(string[] args)
		{

			var builder = WebApplication.CreateBuilder(args);


			builder.Services.AddControllers();
			builder.Services.AddEndpointsApiExplorer();
			builder.Services.AddSwaggerGen();


			var _laConfig = builder.Configuration;
			string? _conString = _laConfig.GetConnectionString("conexionMysql");

   builder.Services.AddDbContext<DbZeroContext>(options => {
    // sql server
    //options.UseSqlServer("conexionSqlServer");
    //


    // mysql
    options.UseMySQL(_conString);
    
   
}
   );


   //builder.Services.AddDatabaseDeveloperPageExceptionFilter();


   builder.Services.AddRouting(opcRutas => opcRutas.LowercaseUrls = true);


   var app = builder.Build();

			if (app.Environment.IsDevelopment())
			{
				app.UseSwagger();
				app.UseSwaggerUI();
			}

			app.UseAuthorization();
			app.MapControllers();
			app.Run();

		}


	}


}
