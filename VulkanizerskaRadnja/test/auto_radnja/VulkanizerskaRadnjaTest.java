package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import auto_radnja.gume.AutoGuma;
import auto_radnja.Radnja;
import auto_radnja.VulkanizerskaRadnja;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VulkanizerskaRadnjaTest extends RadnjaTest{
	
	

	@BeforeEach
	void setUp() throws Exception {
		r = new VulkanizerskaRadnja();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		r = null;
	}

}
