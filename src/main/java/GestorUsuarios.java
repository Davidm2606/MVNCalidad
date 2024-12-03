import java.util.ArrayList;
import java.util.List;

    public class GestorUsuarios {
        private List<Usuario> usuarios;

        public GestorUsuarios() {
            this.usuarios = new ArrayList<Usuario>();
        }

    // CREATE: Agregar un nuevo usuario
    public void agregarUsuario(int id, String nombre, String correo) {
        Usuario usuario = new Usuario(id, nombre, correo);
        usuarios.add(usuario);
    }

    // READ: Obtener un usuario por ID
    public Usuario obtenerUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    // READ: Obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarios;
    }

    // UPDATE: Actualizar un usuario existente
    public boolean actualizarUsuario(int id, String nuevoNombre, String nuevoCorreo) {
        Usuario usuario = obtenerUsuarioPorId(id);
        if (usuario != null) {
            usuario.setNombre(nuevoNombre);
            usuario.setCorreo(nuevoCorreo);
            return true;
        }
        return false;
    }

    // DELETE: Eliminar un usuario por ID
    public boolean eliminarUsuario(int id) {
        Usuario usuario = obtenerUsuarioPorId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }
}