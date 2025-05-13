package com.projectjava.demosclient.services.productoService;

import com.projectjava.demosclient.dao.ProductoDao;
import com.projectjava.demosclient.entity.Productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServicesImpl implements ProductoServices {
    @Autowired
    ProductoDao productoDao;


    @Override
    public Page<Productos> findAll(Pageable pageable, String palabraClave) {
        if(palabraClave != null) {
            return productoDao.findAll(pageable, palabraClave);
        }
        return productoDao.findAll(pageable);
    }
/*
    @Override
    @Transactional(readOnly = true)
    public List<Productos> listProductos(String palabraClave) {
        if (palabraClave != null) {
            return productoDao.findAll(palabraClave);
        }
        return productoDao.findAll();
    }

 */

    @Override
    @Transactional
    public void guardarProducto(Productos producto) {
        productoDao.save(producto);

    }

    @Override
    public void eliminarProducto(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    public Productos editarProducto(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    /*    @Override
    @Transactional
    public List<Productos> importExcel(MultipartFile file) throws Exception {
        // Creamos lista para que reciba las columnas y que sean de tipo producto especifcamente

        // Aquí se lee o se carga el archivo Excel y se procesa su contenido
            XSSFWorkbook workbook = XSSFWorkbookFactory.createWorkbook(OPCPackage.open(new ByteArrayInputStream(file.getBytes())));
            XSSFSheet sheet = workbook.getSheetAt(0);
            List<Productos> data = new ArrayList<>();
             //Obtengo las filas
            for (Row row : sheet) {
                Productos objProducto = new Productos();
                objProducto.setId((long) row.getCell(1).getNumericCellValue());
                objProducto.setCodigo((int) row.getCell(2).getNumericCellValue());
                objProducto.setCategoria(row.getCell(3).getStringCellValue());
                objProducto.setAlmacen(row.getCell(4).getStringCellValue());
                objProducto.setDescripcion(row.getCell(5).getStringCellValue());

                // Lo guardo en la lista a los valores obtenidos en la tabla de excel
                data.add(objProducto);
            }
        return productoDao.saveAll(data);
        }
*/

    }
