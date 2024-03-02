
import com.rodriguez.Circulo;
import com.rodriguez.Figura;
import org.junit.Assert;
import org.junit.Test;

public class CirculoTest {

	final double radio = 5;

	final double pi = 3.1416;

	@Test
	public void circuloArea()
	{

		Figura circulo1 = new Circulo(radio);

		double areaEsperada = pi * radio * radio;

		Assert.assertEquals( areaEsperada, circulo1.getArea(), 4 );

	} // test case N



	@Test
	public void circuloPerimetro()
	{

		Figura circulo1 = new Circulo(radio);

		double perimetroEsperado = 2 * pi * radio;

		Assert.assertEquals( perimetroEsperado, circulo1.getPerimetro(), 4 );

	} // test case N


} // class
