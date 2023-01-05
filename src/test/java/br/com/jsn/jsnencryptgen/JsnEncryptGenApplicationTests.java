package br.com.jsn.jsnencryptgen;

import br.com.jsn.jsnencryptgen.service.MD5Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@SpringBootTest
class JsnEncryptGenApplicationTests {


	@Autowired
	br.com.jsn.jsnencryptgen.service.MD5Service mD5Service ;

	@Test
	void contextLoads() {

		String result = mD5Service.getSecurePasswordMD5("teste", mD5Service.getSalt());
		boolean senha = mD5Service.validar(result , "teste");

		Assert.isTrue(senha);
	}

}
