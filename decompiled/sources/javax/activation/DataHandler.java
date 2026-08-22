package javax.activation;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes9.dex */
public class DataHandler implements Transferable {
    private static final DataFlavor[] emptyFlavors = new DataFlavor[0];
    private static DataContentHandlerFactory factory = null;
    private CommandMap currentCommandMap;
    private DataContentHandler dataContentHandler;
    private DataSource dataSource;
    private DataContentHandler factoryDCH;
    private DataSource objDataSource;
    private Object object;
    private String objectMimeType;
    private DataContentHandlerFactory oldFactory;
    private String shortType;
    private DataFlavor[] transferFlavors;

    public DataHandler(DataSource dataSource) {
        this.objDataSource = null;
        this.object = null;
        this.objectMimeType = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.shortType = null;
        this.dataSource = dataSource;
        this.oldFactory = factory;
    }

    public DataHandler(Object obj, String str) {
        this.dataSource = null;
        this.objDataSource = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.shortType = null;
        this.object = obj;
        this.objectMimeType = str;
        this.oldFactory = factory;
    }

    public DataHandler(URL url) {
        this.dataSource = null;
        this.objDataSource = null;
        this.object = null;
        this.objectMimeType = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.oldFactory = null;
        this.shortType = null;
        this.dataSource = new URLDataSource(url);
        this.oldFactory = factory;
    }

    private synchronized CommandMap getCommandMap() {
        CommandMap commandMap = this.currentCommandMap;
        if (commandMap != null) {
            return commandMap;
        }
        return CommandMap.getDefaultCommandMap();
    }

    public DataSource getDataSource() {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource;
        }
        if (this.objDataSource == null) {
            this.objDataSource = new DataHandlerDataSource(this);
        }
        return this.objDataSource;
    }

    public String getName() {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getName();
        }
        return null;
    }

    public String getContentType() {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getContentType();
        }
        return this.objectMimeType;
    }

    public InputStream getInputStream() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getInputStream();
        }
        final DataContentHandler dataContentHandler = getDataContentHandler();
        if (dataContentHandler == null) {
            throw new UnsupportedDataTypeException("no DCH for MIME type " + getBaseType());
        }
        if ((dataContentHandler instanceof ObjectDataContentHandler) && ((ObjectDataContentHandler) dataContentHandler).getDCH() == null) {
            throw new UnsupportedDataTypeException("no object DCH for MIME type " + getBaseType());
        }
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
        new Thread(new Runnable() { // from class: javax.activation.DataHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        dataContentHandler.writeTo(DataHandler.this.object, DataHandler.this.objectMimeType, pipedOutputStream);
                        pipedOutputStream.close();
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    pipedOutputStream.close();
                } catch (Throwable th) {
                    try {
                        pipedOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            }
        }, "DataHandler.getInputStream").start();
        return pipedInputStream;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            byte[] bArr = new byte[8192];
            InputStream inputStream = dataSource.getInputStream();
            while (true) {
                try {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        return;
                    } else {
                        outputStream.write(bArr, 0, i);
                    }
                } finally {
                    inputStream.close();
                }
            }
        } else {
            getDataContentHandler().writeTo(this.object, this.objectMimeType, outputStream);
        }
    }

    public OutputStream getOutputStream() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getOutputStream();
        }
        return null;
    }

    public synchronized DataFlavor[] getTransferDataFlavors() {
        if (factory != this.oldFactory) {
            this.transferFlavors = emptyFlavors;
        }
        DataFlavor[] dataFlavorArr = this.transferFlavors;
        DataFlavor[] dataFlavorArr2 = emptyFlavors;
        if (dataFlavorArr == dataFlavorArr2) {
            this.transferFlavors = getDataContentHandler().getTransferDataFlavors();
        }
        DataFlavor[] dataFlavorArr3 = this.transferFlavors;
        if (dataFlavorArr3 == dataFlavorArr2) {
            return dataFlavorArr3;
        }
        return (DataFlavor[]) dataFlavorArr3.clone();
    }

    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        for (DataFlavor dataFlavor2 : getTransferDataFlavors()) {
            if (dataFlavor2.equals(dataFlavor)) {
                return true;
            }
        }
        return false;
    }

    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        return getDataContentHandler().getTransferData(dataFlavor, this.dataSource);
    }

    public synchronized void setCommandMap(CommandMap commandMap) {
        if (commandMap != this.currentCommandMap || commandMap == null) {
            this.transferFlavors = emptyFlavors;
            this.dataContentHandler = null;
            this.currentCommandMap = commandMap;
        }
    }

    public CommandInfo[] getPreferredCommands() {
        if (this.dataSource != null) {
            return getCommandMap().getPreferredCommands(getBaseType(), this.dataSource);
        }
        return getCommandMap().getPreferredCommands(getBaseType());
    }

    public CommandInfo[] getAllCommands() {
        if (this.dataSource != null) {
            return getCommandMap().getAllCommands(getBaseType(), this.dataSource);
        }
        return getCommandMap().getAllCommands(getBaseType());
    }

    public CommandInfo getCommand(String str) {
        if (this.dataSource != null) {
            return getCommandMap().getCommand(getBaseType(), str, this.dataSource);
        }
        return getCommandMap().getCommand(getBaseType(), str);
    }

    public Object getContent() throws IOException {
        Object obj = this.object;
        return obj != null ? obj : getDataContentHandler().getContent(getDataSource());
    }

    public Object getBean(CommandInfo commandInfo) {
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            return commandInfo.getCommandObject(this, contextClassLoader);
        } catch (IOException | ClassNotFoundException unused) {
            return null;
        }
    }

    private synchronized DataContentHandler getDataContentHandler() {
        DataContentHandlerFactory dataContentHandlerFactory;
        DataContentHandlerFactory dataContentHandlerFactory2 = factory;
        if (dataContentHandlerFactory2 != this.oldFactory) {
            this.oldFactory = dataContentHandlerFactory2;
            this.factoryDCH = null;
            this.dataContentHandler = null;
            this.transferFlavors = emptyFlavors;
        }
        DataContentHandler dataContentHandler = this.dataContentHandler;
        if (dataContentHandler != null) {
            return dataContentHandler;
        }
        String baseType = getBaseType();
        if (this.factoryDCH == null && (dataContentHandlerFactory = factory) != null) {
            this.factoryDCH = dataContentHandlerFactory.createDataContentHandler(baseType);
        }
        DataContentHandler dataContentHandler2 = this.factoryDCH;
        if (dataContentHandler2 != null) {
            this.dataContentHandler = dataContentHandler2;
        }
        if (this.dataContentHandler == null) {
            if (this.dataSource != null) {
                this.dataContentHandler = getCommandMap().createDataContentHandler(baseType, this.dataSource);
            } else {
                this.dataContentHandler = getCommandMap().createDataContentHandler(baseType);
            }
        }
        if (this.dataSource != null) {
            this.dataContentHandler = new DataSourceDataContentHandler(this.dataContentHandler, this.dataSource);
        } else {
            this.dataContentHandler = new ObjectDataContentHandler(this.dataContentHandler, this.object, this.objectMimeType);
        }
        return this.dataContentHandler;
    }

    private synchronized String getBaseType() {
        if (this.shortType == null) {
            String contentType = getContentType();
            try {
                this.shortType = new MimeType(contentType).getBaseType();
            } catch (MimeTypeParseException unused) {
                this.shortType = contentType;
            }
        }
        return this.shortType;
    }

    public static synchronized void setDataContentHandlerFactory(DataContentHandlerFactory dataContentHandlerFactory) {
        if (factory != null) {
            throw new Error("DataContentHandlerFactory already defined");
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            try {
                securityManager.checkSetFactory();
            } catch (SecurityException e2) {
                if (DataHandler.class.getClassLoader() != dataContentHandlerFactory.getClass().getClassLoader()) {
                    throw e2;
                }
            }
        }
        factory = dataContentHandlerFactory;
    }
}
