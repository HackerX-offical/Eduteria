package com.clevertap.android.sdk.inapp.customtemplates;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inapp.InAppListener;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateContext;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TemplatesManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u000bJ\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u000eH\u0016J\"\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplateContext$ContextDismissListener;", "templates", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "logger", "Lcom/clevertap/android/sdk/Logger;", "<init>", "(Ljava/util/Collection;Lcom/clevertap/android/sdk/Logger;)V", "customTemplates", "", "", "activeContexts", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplateContext;", "isTemplateRegistered", "", CustomTemplateInAppData.KEY_TEMPLATE_NAME, "getAllRegisteredTemplates", "", "getTemplate", "getActiveContextForTemplate", "presentTemplate", "", "notification", "Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "inAppListener", "Lcom/clevertap/android/sdk/inapp/InAppListener;", "resourceProvider", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "closeTemplate", "onDismissContext", "context", "createContextFromInApp", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TemplatesManager implements CustomTemplateContext.ContextDismissListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<TemplateProducer> templateProducers = new ArrayList();
    private final Map<String, CustomTemplateContext> activeContexts;
    private final Map<String, CustomTemplate> customTemplates;
    private final Logger logger;

    @JvmStatic
    public static final TemplatesManager createInstance(CleverTapInstanceConfig cleverTapInstanceConfig, Set<CustomTemplate> set) {
        return INSTANCE.createInstance(cleverTapInstanceConfig, set);
    }

    @JvmStatic
    public static final void register(TemplateProducer templateProducer) {
        INSTANCE.register(templateProducer);
    }

    public TemplatesManager(Collection<CustomTemplate> templates, Logger logger) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        Collection<CustomTemplate> collection = templates;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collection, 10)), 16));
        for (Object obj : collection) {
            linkedHashMap.put(((CustomTemplate) obj).getName(), obj);
        }
        this.customTemplates = linkedHashMap;
        this.activeContexts = new LinkedHashMap();
    }

    /* JADX INFO: compiled from: TemplatesManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J\u0006\u0010\u0011\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager$Companion;", "", "<init>", "()V", "templateProducers", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/TemplateProducer;", "register", "", "templateProducer", "createInstance", "Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;", "ctInstanceConfig", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "systemTemplates", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "clearRegisteredProducers", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void register(TemplateProducer templateProducer) {
            Intrinsics.checkNotNullParameter(templateProducer, "templateProducer");
            TemplatesManager.templateProducers.add(templateProducer);
        }

        @JvmStatic
        public final TemplatesManager createInstance(CleverTapInstanceConfig ctInstanceConfig, Set<CustomTemplate> systemTemplates) {
            Intrinsics.checkNotNullParameter(ctInstanceConfig, "ctInstanceConfig");
            Intrinsics.checkNotNullParameter(systemTemplates, "systemTemplates");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = TemplatesManager.templateProducers.iterator();
            while (it.hasNext()) {
                for (CustomTemplate customTemplate : ((TemplateProducer) it.next()).defineTemplates(ctInstanceConfig)) {
                    if (customTemplate.getIsSystemDefined()) {
                        throw new CustomTemplateException("Cannot define system template with a name \"" + customTemplate.getName() + "\".", null, 2, null);
                    }
                    if (systemTemplates.contains(customTemplate)) {
                        throw new CustomTemplateException("CustomTemplate with a name \"" + customTemplate.getName() + "\" is a system template.", null, 2, null);
                    }
                    if (linkedHashSet.contains(customTemplate)) {
                        throw new CustomTemplateException("CustomTemplate with a name \"" + customTemplate.getName() + "\" is already registered.", null, 2, null);
                    }
                    linkedHashSet.add(customTemplate);
                }
            }
            linkedHashSet.addAll(systemTemplates);
            Logger logger = ctInstanceConfig.getLogger();
            Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
            return new TemplatesManager(linkedHashSet, logger);
        }

        public final void clearRegisteredProducers() {
            TemplatesManager.templateProducers.clear();
        }
    }

    public final boolean isTemplateRegistered(String templateName) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        return this.customTemplates.containsKey(templateName);
    }

    public final List<CustomTemplate> getAllRegisteredTemplates() {
        Collection<CustomTemplate> collectionValues = this.customTemplates.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((CustomTemplate) obj).getIsSystemDefined()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final CustomTemplate getTemplate(String templateName) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        return this.customTemplates.get(templateName);
    }

    public final CustomTemplateContext getActiveContextForTemplate(String templateName) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        return this.activeContexts.get(templateName);
    }

    public final void presentTemplate(CTInAppNotification notification, InAppListener inAppListener, FileResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(inAppListener, "inAppListener");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        CustomTemplateContext customTemplateContextCreateContextFromInApp = createContextFromInApp(notification, inAppListener, resourceProvider);
        if (customTemplateContextCreateContextFromInApp == null) {
            return;
        }
        CustomTemplate customTemplate = this.customTemplates.get(customTemplateContextCreateContextFromInApp.getTemplateName());
        if (customTemplate == null) {
            this.logger.info("CustomTemplates", "Cannot find template with name " + customTemplateContextCreateContextFromInApp.getTemplateName());
            return;
        }
        CustomTemplatePresenter<?> presenter = customTemplate.getPresenter();
        if (presenter instanceof TemplatePresenter) {
            if (customTemplateContextCreateContextFromInApp instanceof CustomTemplateContext.TemplateContext) {
                this.activeContexts.put(customTemplate.getName(), customTemplateContextCreateContextFromInApp);
                ((TemplatePresenter) presenter).onPresent(customTemplateContextCreateContextFromInApp);
                return;
            }
            return;
        }
        if ((presenter instanceof FunctionPresenter) && (customTemplateContextCreateContextFromInApp instanceof CustomTemplateContext.FunctionContext)) {
            this.activeContexts.put(customTemplate.getName(), customTemplateContextCreateContextFromInApp);
            ((FunctionPresenter) presenter).onPresent(customTemplateContextCreateContextFromInApp);
        }
    }

    public final void closeTemplate(CTInAppNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        CustomTemplateInAppData customTemplateData = notification.getCustomTemplateData();
        String templateName = customTemplateData != null ? customTemplateData.getTemplateName() : null;
        if (templateName == null) {
            this.logger.debug("CustomTemplates", "Cannot close custom template from notification without template name");
            return;
        }
        CustomTemplateContext customTemplateContext = this.activeContexts.get(templateName);
        if (customTemplateContext == null) {
            this.logger.debug("CustomTemplates", "Cannot close custom template without active context");
            return;
        }
        CustomTemplate customTemplate = this.customTemplates.get(templateName);
        if (customTemplate == null) {
            this.logger.info("CustomTemplates", "Cannot find template with name " + templateName);
            return;
        }
        CustomTemplatePresenter<?> presenter = customTemplate.getPresenter();
        if ((presenter instanceof TemplatePresenter) && (customTemplateContext instanceof CustomTemplateContext.TemplateContext)) {
            ((TemplatePresenter) presenter).onClose((CustomTemplateContext.TemplateContext) customTemplateContext);
        }
    }

    @Override // com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateContext.ContextDismissListener
    public void onDismissContext(CustomTemplateContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.activeContexts.remove(context.getTemplateName());
    }

    private final CustomTemplateContext createContextFromInApp(CTInAppNotification notification, InAppListener inAppListener, FileResourceProvider resourceProvider) {
        CustomTemplateInAppData customTemplateData = notification.getCustomTemplateData();
        String templateName = customTemplateData != null ? customTemplateData.getTemplateName() : null;
        if (templateName == null) {
            this.logger.debug("CustomTemplates", "Cannot create TemplateContext from notification without template name");
            return null;
        }
        CustomTemplate customTemplate = this.customTemplates.get(templateName);
        if (customTemplate == null) {
            this.logger.debug("CustomTemplates", "Cannot create TemplateContext for non-registered template: " + templateName);
            return null;
        }
        return CustomTemplateContext.INSTANCE.createContext$clevertap_core_release(customTemplate, notification, inAppListener, resourceProvider, this, this.logger);
    }
}
