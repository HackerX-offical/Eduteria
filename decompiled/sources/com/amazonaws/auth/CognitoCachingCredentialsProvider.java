package com.amazonaws.auth;

import android.content.Context;
import android.util.Log;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.NotAuthorizedException;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.util.VersionInfoUtils;
import java.util.Date;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class CognitoCachingCredentialsProvider extends CognitoCredentialsProvider {
    private static final String AK_KEY = "accessKey";
    private static final String EXP_KEY = "expirationDate";
    private static final String ID_KEY = "identityId";
    private static final String SK_KEY = "secretKey";
    private static final String ST_KEY = "sessionToken";
    private static final String TAG = "CognitoCachingCredentialsProvider";
    private static final String USER_AGENT = CognitoCachingCredentialsProvider.class.getName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + VersionInfoUtils.getVersion();
    private final String DEFAULT_SHAREDPREFERENCES_NAME;
    private AWSKeyValueStore awsKeyValueStore;
    private String identityId;
    private boolean isPersistenceEnabled;
    private final IdentityChangedListener listener;
    volatile boolean needIdentityRefresh;

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, Regions regions) {
        super(str, str2, str3, str4, regions);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, Regions regions, ClientConfiguration clientConfiguration) {
        super(str, str2, str3, str4, regions, clientConfiguration);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, String str, Regions regions) {
        super(str, regions);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSConfiguration aWSConfiguration) {
        super(aWSConfiguration);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, String str, Regions regions, ClientConfiguration clientConfiguration) {
        super(str, regions, clientConfiguration);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, AmazonCognitoIdentityClient amazonCognitoIdentityClient, AWSSecurityTokenService aWSSecurityTokenService) {
        super(str, str2, str3, str4, amazonCognitoIdentityClient, aWSSecurityTokenService);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2) {
        super(aWSCognitoIdentityProvider, str, str2);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2, AWSSecurityTokenService aWSSecurityTokenService) {
        super(aWSCognitoIdentityProvider, str, str2, aWSSecurityTokenService);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions) {
        super(aWSCognitoIdentityProvider, regions);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions, ClientConfiguration clientConfiguration) {
        super(aWSCognitoIdentityProvider, regions, clientConfiguration);
        this.DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
        this.needIdentityRefresh = false;
        this.isPersistenceEnabled = true;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    private void initialize(Context context) {
        try {
            this.awsKeyValueStore = new AWSKeyValueStore(context, "com.amazonaws.android.auth", this.isPersistenceEnabled);
            checkUpgrade();
            this.identityId = getCachedIdentityId();
            loadCachedCredentials();
            registerIdentityChangedListener(this.listener);
        } catch (Exception e2) {
            Log.e(TAG, "Error in initializing the CognitoCachingCredentialsProvider. " + e2);
            throw new IllegalStateException("Error in initializing the CognitoCachingCredentialsProvider. ", e2);
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public String getIdentityId() {
        if (this.needIdentityRefresh) {
            this.needIdentityRefresh = false;
            refresh();
            String identityId = super.getIdentityId();
            this.identityId = identityId;
            saveIdentityId(identityId);
        }
        String cachedIdentityId = getCachedIdentityId();
        this.identityId = cachedIdentityId;
        if (cachedIdentityId == null) {
            String identityId2 = super.getIdentityId();
            this.identityId = identityId2;
            saveIdentityId(identityId2);
        }
        return this.identityId;
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider, com.amazonaws.auth.AWSCredentialsProvider
    public AWSSessionCredentials getCredentials() {
        AWSSessionCredentials aWSSessionCredentials;
        this.credentialsLock.writeLock().lock();
        try {
            try {
                if (this.sessionCredentials == null) {
                    loadCachedCredentials();
                }
                if (this.sessionCredentialsExpiration == null || needsNewSession()) {
                    Log.d(TAG, "Making a network call to fetch credentials.");
                    super.getCredentials();
                    if (this.sessionCredentialsExpiration != null) {
                        saveCredentials(this.sessionCredentials, this.sessionCredentialsExpiration.getTime());
                    }
                    aWSSessionCredentials = this.sessionCredentials;
                } else {
                    aWSSessionCredentials = this.sessionCredentials;
                }
            } catch (NotAuthorizedException e2) {
                Log.e(TAG, "Failure to get credentials", e2);
                if (getLogins() != null) {
                    super.setIdentityId(null);
                    super.getCredentials();
                    aWSSessionCredentials = this.sessionCredentials;
                } else {
                    throw e2;
                }
            }
            return aWSSessionCredentials;
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider, com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
        this.credentialsLock.writeLock().lock();
        try {
            super.refresh();
            if (this.sessionCredentialsExpiration != null) {
                saveCredentials(this.sessionCredentials, this.sessionCredentialsExpiration.getTime());
            }
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void setLogins(Map<String, String> map) {
        this.credentialsLock.writeLock().lock();
        try {
            super.setLogins(map);
            this.needIdentityRefresh = true;
            clearCredentials();
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void clear() {
        super.clear();
        this.awsKeyValueStore.clear();
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void clearCredentials() {
        this.credentialsLock.writeLock().lock();
        try {
            super.clearCredentials();
            Log.d(TAG, "Clearing credentials from SharedPreferences");
            this.awsKeyValueStore.remove(namespace(AK_KEY));
            this.awsKeyValueStore.remove(namespace(SK_KEY));
            this.awsKeyValueStore.remove(namespace(ST_KEY));
            this.awsKeyValueStore.remove(namespace(EXP_KEY));
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public String getCachedIdentityId() {
        String str = this.awsKeyValueStore.get(namespace(ID_KEY));
        if (str != null && this.identityId == null) {
            super.setIdentityId(str);
        }
        return str;
    }

    private void loadCachedCredentials() {
        Log.d(TAG, "Loading credentials from SharedPreferences");
        if (this.awsKeyValueStore.get(namespace(EXP_KEY)) != null) {
            this.sessionCredentialsExpiration = new Date(Long.parseLong(this.awsKeyValueStore.get(namespace(EXP_KEY))));
        } else {
            this.sessionCredentialsExpiration = new Date(0L);
        }
        boolean zContains = this.awsKeyValueStore.contains(namespace(AK_KEY));
        boolean zContains2 = this.awsKeyValueStore.contains(namespace(SK_KEY));
        boolean zContains3 = this.awsKeyValueStore.contains(namespace(ST_KEY));
        if (!zContains || !zContains2 || !zContains3) {
            Log.d(TAG, "No valid credentials found in SharedPreferences");
            this.sessionCredentialsExpiration = null;
            return;
        }
        String str = this.awsKeyValueStore.get(namespace(AK_KEY));
        String str2 = this.awsKeyValueStore.get(namespace(SK_KEY));
        String str3 = this.awsKeyValueStore.get(namespace(ST_KEY));
        if (str == null || str2 == null || str3 == null) {
            Log.d(TAG, "No valid credentials found in SharedPreferences");
            this.sessionCredentialsExpiration = null;
        } else {
            this.sessionCredentials = new BasicSessionCredentials(str, str2, str3);
        }
    }

    private void saveCredentials(AWSSessionCredentials aWSSessionCredentials, long j) {
        Log.d(TAG, "Saving credentials to SharedPreferences");
        if (aWSSessionCredentials != null) {
            this.awsKeyValueStore.put(namespace(AK_KEY), aWSSessionCredentials.getAWSAccessKeyId());
            this.awsKeyValueStore.put(namespace(SK_KEY), aWSSessionCredentials.getAWSSecretKey());
            this.awsKeyValueStore.put(namespace(ST_KEY), aWSSessionCredentials.getSessionToken());
            this.awsKeyValueStore.put(namespace(EXP_KEY), String.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveIdentityId(String str) {
        Log.d(TAG, "Saving identity id to SharedPreferences");
        this.identityId = str;
        this.awsKeyValueStore.put(namespace(ID_KEY), str);
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    protected String getUserAgent() {
        return USER_AGENT;
    }

    private void checkUpgrade() {
        if (this.awsKeyValueStore.contains(ID_KEY)) {
            Log.i(TAG, "Identity id without namespace is detected. It will be saved under new namespace.");
            String str = this.awsKeyValueStore.get(ID_KEY);
            this.awsKeyValueStore.clear();
            this.awsKeyValueStore.put(namespace(ID_KEY), str);
        }
    }

    private String namespace(String str) {
        return getIdentityPoolId() + InstructionFileId.DOT + str;
    }

    public void setPersistenceEnabled(boolean z) {
        this.isPersistenceEnabled = z;
        this.awsKeyValueStore.setPersistenceEnabled(z);
    }
}
