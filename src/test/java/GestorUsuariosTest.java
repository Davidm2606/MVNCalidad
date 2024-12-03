import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorUsuariosTest {

    @Test
    public void testCrearUsuario() {
        GestorUsuarios gestor = new GestorUsuarios();
        gestor.agregarUsuario(1, "Juan Perez", "juan.perez@example.com");

        assertEquals(1, gestor.obtenerTodosLosUsuarios().size());
    }

    @Test
    public void testLeerUsuario() {
        GestorUsuarios gestor = new GestorUsuarios();
        gestor.agregarUsuario(1, "Juan Perez", "juan.perez@example.com");

        Usuario usuario = gestor.obtenerUsuarioPorId(1);
        assertNotNull(usuario);
        assertEquals("Juan Perez", usuario.getNombre());
    }

    @Test
    public void testActualizarUsuario() {
        GestorUsuarios gestor = new GestorUsuarios();
        gestor.agregarUsuario(1, "Juan Perez", "juan.perez@example.com");

        boolean actualizado = gestor.actualizarUsuario(1, "Juan P.", "juan.p@example.com");
        assertTrue(actualizado);

        Usuario usuario = gestor.obtenerUsuarioPorId(1);
        assertEquals("Juan P.", usuario.getNombre());
        assertEquals("juan.p@example.com", usuario.getCorreo());
    }

    @Test
    public void testEliminarUsuario() {
        GestorUsuarios gestor = new GestorUsuarios();
        gestor.agregarUsuario(1, "Juan Perez", "juan.perez@example.com");

        boolean eliminado = gestor.eliminarUsuario(1);
        assertTrue(eliminado);

        Usuario usuario = gestor.obtenerUsuarioPorId(1);
        assertNull(usuario);
    }
}