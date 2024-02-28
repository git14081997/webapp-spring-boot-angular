
import com.rodriguez.Cuadrado;
import com.rodriguez.Figura;
import org.junit.Assert;
import org.junit.Test;

public class CuadradoTest
{

	@Test
	public void cuadradoArea()
	{

		final double sizeLado = 10.00;

		Figura cuadrado1 = new Cuadrado( sizeLado );

		final double areaEsperada = 100;

		Assert.assertEquals( areaEsperada, cuadrado1.getArea(), 4 );

	} // test case N



	@Test
	public void cuadradoPerimetro()
	{

		final double sizeLado = 10.00;

		Figura cuadrado1 = new Cuadrado( sizeLado );

		final double perimetroEsperado = 40;

		Assert.assertEquals( perimetroEsperado, cuadrado1.getPerimetro(), 4 );

	} // test case N



} // class
