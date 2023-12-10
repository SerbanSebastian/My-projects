package driver;

import presentationLayer.*;
import buttons.*;

public class Controller {
    private StartFrame start;
    private ClientFrame client;
    private ProductFrame product;
    private OrderFrame order;
    private AddClientFrame addClientFrame;
    private AddProductFrame addProductFrame;
    private DeleteClientFrame deleteClientFrame;
    private DeleteProductFrame deleteProductFrame;
    private ListAllProductsFrame listAllProductsFrame;
    private ListAllClientsFrame listAllClientsFrame;
    private UpdateClientFrame updateClientFrame;
    private UpdateProductFrame updateProductFrame;


    public Controller() throws Exception {
        start = new StartFrame();
        client = new ClientFrame();
        product = new ProductFrame();
        order = new OrderFrame();
        addClientFrame = new AddClientFrame();
        addProductFrame = new AddProductFrame();
        deleteClientFrame = new DeleteClientFrame();
        deleteProductFrame = new DeleteProductFrame();
        listAllClientsFrame = new ListAllClientsFrame();
        listAllProductsFrame = new ListAllProductsFrame();
        updateClientFrame = new UpdateClientFrame();
        updateProductFrame = new UpdateProductFrame();

        //Start frame
        start.addClientListener(new SwapFrameButton(start, client));
        start.addProductListener(new SwapFrameButton(start, product));
        start.addOrderListener(new SwapFrameButton(start, order));

        //Client Frame
        client.addBackListener(new SwapFrameButton(client, start));
        client.addAddListener(new SwapFrameButton(client, addClientFrame));
        client.addEditListener(new SwapFrameButton(client, updateClientFrame));
        client.addDeleteListener(new SwapFrameButton(client, deleteClientFrame));
        client.addViewListener(new SwapFrameButton(client, listAllClientsFrame));

        //Product frame
        product.addBackListener(new SwapFrameButton(product, start));
        product.addAddListener(new SwapFrameButton(product, addProductFrame));
        product.addEditListener(new SwapFrameButton(product, updateProductFrame));
        product.addDeleteListener(new SwapFrameButton(product, deleteProductFrame));
        product.addViewListener(new SwapFrameButton(product, listAllProductsFrame));

        //Order Frame (with add operation)
        order.addBackListener(new SwapFrameButton(order, start));
        order.addEnterListener(new AddOrder(order));

        //Client operations (add, delete, update, listAll)
        addClientFrame.addBackListener(new SwapFrameButton(addClientFrame, client));
        addClientFrame.addEnterListener(new AddClient(addClientFrame));
        deleteClientFrame.addBackListener(new SwapFrameButton(deleteClientFrame, client));
        deleteClientFrame.addDeleteListener(new DeleteClient(deleteClientFrame));
        updateClientFrame.addBackListener(new SwapFrameButton(updateClientFrame, client));
        updateClientFrame.addUpdateListener(new EditClient(updateClientFrame));
        updateClientFrame.addClientListener(new ChoseClient(updateClientFrame.getClientBox(), updateClientFrame));
        listAllClientsFrame.addBackListener(new SwapFrameButton(listAllClientsFrame, client));

        //Product operations <add, delete, update, listAll)
        addProductFrame.addBackListener(new SwapFrameButton(addProductFrame, product));
        addProductFrame.addEnterListener(new AddProduct(addProductFrame));
        deleteProductFrame.addBackListener(new SwapFrameButton(deleteProductFrame, product));
        deleteProductFrame.addDeleteListener(new DeleteProduct(deleteProductFrame));
        updateProductFrame.addBackListener(new SwapFrameButton(updateProductFrame, product));
        updateProductFrame.addUpdateListener(new EditProduct(updateProductFrame));
        updateProductFrame.addComboListener(new ChoseProduct(updateProductFrame.getProductBox(), updateProductFrame));
        listAllProductsFrame.addBackListener(new SwapFrameButton(listAllProductsFrame, product));
    }
}
