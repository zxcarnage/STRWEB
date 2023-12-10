
import com.Model.Product;
import com.dao.ProductDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.core.LauncherFactory;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//mvn test -Dtest=testJ5
@ExtendWith(MockitoExtension.class)
public class testj {
    ProductDao productDao = Mockito.spy(ProductDao.class);
    /*ProductDao productDao = new ProductDao();
    productDaoSpy = Mockito.spy(productDao);

     */

    @Test
    public void testAdd() {
        Product result = new Product("razer viper", "Техника", 5,500);
        when(productDao.findByName("razer viper")).thenReturn(result);
    }

}

