package org.joda.time.convert;

import com.amazonaws.services.s3.internal.Constants;
import org.joda.time.JodaTimePermission;

/* JADX INFO: loaded from: classes10.dex */
public final class ConverterManager {
    private static ConverterManager INSTANCE;
    private ConverterSet iInstantConverters = new ConverterSet(new Converter[]{ReadableInstantConverter.INSTANCE, StringConverter.INSTANCE, CalendarConverter.INSTANCE, DateConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE});
    private ConverterSet iPartialConverters = new ConverterSet(new Converter[]{ReadablePartialConverter.INSTANCE, ReadableInstantConverter.INSTANCE, StringConverter.INSTANCE, CalendarConverter.INSTANCE, DateConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE});
    private ConverterSet iDurationConverters = new ConverterSet(new Converter[]{ReadableDurationConverter.INSTANCE, ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE});
    private ConverterSet iPeriodConverters = new ConverterSet(new Converter[]{ReadableDurationConverter.INSTANCE, ReadablePeriodConverter.INSTANCE, ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, NullConverter.INSTANCE});
    private ConverterSet iIntervalConverters = new ConverterSet(new Converter[]{ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, NullConverter.INSTANCE});

    public static ConverterManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConverterManager();
        }
        return INSTANCE;
    }

    protected ConverterManager() {
    }

    public InstantConverter getInstantConverter(Object obj) {
        InstantConverter instantConverter = (InstantConverter) this.iInstantConverters.select(obj == null ? null : obj.getClass());
        if (instantConverter != null) {
            return instantConverter;
        }
        throw new IllegalArgumentException("No instant converter found for type: " + (obj == null ? Constants.NULL_VERSION_ID : obj.getClass().getName()));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public InstantConverter[] getInstantConverters() {
        ConverterSet converterSet = this.iInstantConverters;
        InstantConverter[] instantConverterArr = new InstantConverter[converterSet.size()];
        converterSet.copyInto(instantConverterArr);
        return instantConverterArr;
    }

    public InstantConverter addInstantConverter(InstantConverter instantConverter) throws SecurityException {
        checkAlterInstantConverters();
        if (instantConverter == null) {
            return null;
        }
        InstantConverter[] instantConverterArr = new InstantConverter[1];
        this.iInstantConverters = this.iInstantConverters.add(instantConverter, instantConverterArr);
        return instantConverterArr[0];
    }

    public InstantConverter removeInstantConverter(InstantConverter instantConverter) throws SecurityException {
        checkAlterInstantConverters();
        if (instantConverter == null) {
            return null;
        }
        InstantConverter[] instantConverterArr = new InstantConverter[1];
        this.iInstantConverters = this.iInstantConverters.remove(instantConverter, instantConverterArr);
        return instantConverterArr[0];
    }

    private void checkAlterInstantConverters() throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("ConverterManager.alterInstantConverters"));
        }
    }

    public PartialConverter getPartialConverter(Object obj) {
        PartialConverter partialConverter = (PartialConverter) this.iPartialConverters.select(obj == null ? null : obj.getClass());
        if (partialConverter != null) {
            return partialConverter;
        }
        throw new IllegalArgumentException("No partial converter found for type: " + (obj == null ? Constants.NULL_VERSION_ID : obj.getClass().getName()));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public PartialConverter[] getPartialConverters() {
        ConverterSet converterSet = this.iPartialConverters;
        PartialConverter[] partialConverterArr = new PartialConverter[converterSet.size()];
        converterSet.copyInto(partialConverterArr);
        return partialConverterArr;
    }

    public PartialConverter addPartialConverter(PartialConverter partialConverter) throws SecurityException {
        checkAlterPartialConverters();
        if (partialConverter == null) {
            return null;
        }
        PartialConverter[] partialConverterArr = new PartialConverter[1];
        this.iPartialConverters = this.iPartialConverters.add(partialConverter, partialConverterArr);
        return partialConverterArr[0];
    }

    public PartialConverter removePartialConverter(PartialConverter partialConverter) throws SecurityException {
        checkAlterPartialConverters();
        if (partialConverter == null) {
            return null;
        }
        PartialConverter[] partialConverterArr = new PartialConverter[1];
        this.iPartialConverters = this.iPartialConverters.remove(partialConverter, partialConverterArr);
        return partialConverterArr[0];
    }

    private void checkAlterPartialConverters() throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("ConverterManager.alterPartialConverters"));
        }
    }

    public DurationConverter getDurationConverter(Object obj) {
        DurationConverter durationConverter = (DurationConverter) this.iDurationConverters.select(obj == null ? null : obj.getClass());
        if (durationConverter != null) {
            return durationConverter;
        }
        throw new IllegalArgumentException("No duration converter found for type: " + (obj == null ? Constants.NULL_VERSION_ID : obj.getClass().getName()));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public DurationConverter[] getDurationConverters() {
        ConverterSet converterSet = this.iDurationConverters;
        DurationConverter[] durationConverterArr = new DurationConverter[converterSet.size()];
        converterSet.copyInto(durationConverterArr);
        return durationConverterArr;
    }

    public DurationConverter addDurationConverter(DurationConverter durationConverter) throws SecurityException {
        checkAlterDurationConverters();
        if (durationConverter == null) {
            return null;
        }
        DurationConverter[] durationConverterArr = new DurationConverter[1];
        this.iDurationConverters = this.iDurationConverters.add(durationConverter, durationConverterArr);
        return durationConverterArr[0];
    }

    public DurationConverter removeDurationConverter(DurationConverter durationConverter) throws SecurityException {
        checkAlterDurationConverters();
        if (durationConverter == null) {
            return null;
        }
        DurationConverter[] durationConverterArr = new DurationConverter[1];
        this.iDurationConverters = this.iDurationConverters.remove(durationConverter, durationConverterArr);
        return durationConverterArr[0];
    }

    private void checkAlterDurationConverters() throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("ConverterManager.alterDurationConverters"));
        }
    }

    public PeriodConverter getPeriodConverter(Object obj) {
        PeriodConverter periodConverter = (PeriodConverter) this.iPeriodConverters.select(obj == null ? null : obj.getClass());
        if (periodConverter != null) {
            return periodConverter;
        }
        throw new IllegalArgumentException("No period converter found for type: " + (obj == null ? Constants.NULL_VERSION_ID : obj.getClass().getName()));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public PeriodConverter[] getPeriodConverters() {
        ConverterSet converterSet = this.iPeriodConverters;
        PeriodConverter[] periodConverterArr = new PeriodConverter[converterSet.size()];
        converterSet.copyInto(periodConverterArr);
        return periodConverterArr;
    }

    public PeriodConverter addPeriodConverter(PeriodConverter periodConverter) throws SecurityException {
        checkAlterPeriodConverters();
        if (periodConverter == null) {
            return null;
        }
        PeriodConverter[] periodConverterArr = new PeriodConverter[1];
        this.iPeriodConverters = this.iPeriodConverters.add(periodConverter, periodConverterArr);
        return periodConverterArr[0];
    }

    public PeriodConverter removePeriodConverter(PeriodConverter periodConverter) throws SecurityException {
        checkAlterPeriodConverters();
        if (periodConverter == null) {
            return null;
        }
        PeriodConverter[] periodConverterArr = new PeriodConverter[1];
        this.iPeriodConverters = this.iPeriodConverters.remove(periodConverter, periodConverterArr);
        return periodConverterArr[0];
    }

    private void checkAlterPeriodConverters() throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("ConverterManager.alterPeriodConverters"));
        }
    }

    public IntervalConverter getIntervalConverter(Object obj) {
        IntervalConverter intervalConverter = (IntervalConverter) this.iIntervalConverters.select(obj == null ? null : obj.getClass());
        if (intervalConverter != null) {
            return intervalConverter;
        }
        throw new IllegalArgumentException("No interval converter found for type: " + (obj == null ? Constants.NULL_VERSION_ID : obj.getClass().getName()));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public IntervalConverter[] getIntervalConverters() {
        ConverterSet converterSet = this.iIntervalConverters;
        IntervalConverter[] intervalConverterArr = new IntervalConverter[converterSet.size()];
        converterSet.copyInto(intervalConverterArr);
        return intervalConverterArr;
    }

    public IntervalConverter addIntervalConverter(IntervalConverter intervalConverter) throws SecurityException {
        checkAlterIntervalConverters();
        if (intervalConverter == null) {
            return null;
        }
        IntervalConverter[] intervalConverterArr = new IntervalConverter[1];
        this.iIntervalConverters = this.iIntervalConverters.add(intervalConverter, intervalConverterArr);
        return intervalConverterArr[0];
    }

    public IntervalConverter removeIntervalConverter(IntervalConverter intervalConverter) throws SecurityException {
        checkAlterIntervalConverters();
        if (intervalConverter == null) {
            return null;
        }
        IntervalConverter[] intervalConverterArr = new IntervalConverter[1];
        this.iIntervalConverters = this.iIntervalConverters.remove(intervalConverter, intervalConverterArr);
        return intervalConverterArr[0];
    }

    private void checkAlterIntervalConverters() throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("ConverterManager.alterIntervalConverters"));
        }
    }

    public String toString() {
        return "ConverterManager[" + this.iInstantConverters.size() + " instant," + this.iPartialConverters.size() + " partial," + this.iDurationConverters.size() + " duration," + this.iPeriodConverters.size() + " period," + this.iIntervalConverters.size() + " interval]";
    }
}
