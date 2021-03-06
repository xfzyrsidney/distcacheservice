/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sidney.dbsyncserver.tserializ.dsp;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TDbSync_Dsp_Winning_Key_Config implements org.apache.thrift.TBase<TDbSync_Dsp_Winning_Key_Config, TDbSync_Dsp_Winning_Key_Config._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Winning_Key_Config> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Winning_Key_Config");

  private static final org.apache.thrift.protocol.TField ADX_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("adxType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField WINNING_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("winningKey", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField KEY_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("keyVersion", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("Status", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Winning_Key_ConfigStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Winning_Key_ConfigTupleSchemeFactory());
  }

  public int adxType; // required
  public String winningKey; // required
  public String keyVersion; // required
  public int Status; // required
  public String lastChanged; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ADX_TYPE((short)1, "adxType"),
    WINNING_KEY((short)2, "winningKey"),
    KEY_VERSION((short)3, "keyVersion"),
    STATUS((short)4, "Status"),
    LAST_CHANGED((short)5, "lastChanged");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ADX_TYPE
          return ADX_TYPE;
        case 2: // WINNING_KEY
          return WINNING_KEY;
        case 3: // KEY_VERSION
          return KEY_VERSION;
        case 4: // STATUS
          return STATUS;
        case 5: // LAST_CHANGED
          return LAST_CHANGED;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ADXTYPE_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ADX_TYPE, new org.apache.thrift.meta_data.FieldMetaData("adxType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.WINNING_KEY, new org.apache.thrift.meta_data.FieldMetaData("winningKey", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.KEY_VERSION, new org.apache.thrift.meta_data.FieldMetaData("keyVersion", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("Status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Winning_Key_Config.class, metaDataMap);
  }

  public TDbSync_Dsp_Winning_Key_Config() {
  }

  public TDbSync_Dsp_Winning_Key_Config(
    int adxType,
    String winningKey,
    String keyVersion,
    int Status,
    String lastChanged)
  {
    this();
    this.adxType = adxType;
    setAdxTypeIsSet(true);
    this.winningKey = winningKey;
    this.keyVersion = keyVersion;
    this.Status = Status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Winning_Key_Config(TDbSync_Dsp_Winning_Key_Config other) {
    __isset_bitfield = other.__isset_bitfield;
    this.adxType = other.adxType;
    if (other.isSetWinningKey()) {
      this.winningKey = other.winningKey;
    }
    if (other.isSetKeyVersion()) {
      this.keyVersion = other.keyVersion;
    }
    this.Status = other.Status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
  }

  public TDbSync_Dsp_Winning_Key_Config deepCopy() {
    return new TDbSync_Dsp_Winning_Key_Config(this);
  }

  @Override
  public void clear() {
    setAdxTypeIsSet(false);
    this.adxType = 0;
    this.winningKey = null;
    this.keyVersion = null;
    setStatusIsSet(false);
    this.Status = 0;
    this.lastChanged = null;
  }

  public int getAdxType() {
    return this.adxType;
  }

  public TDbSync_Dsp_Winning_Key_Config setAdxType(int adxType) {
    this.adxType = adxType;
    setAdxTypeIsSet(true);
    return this;
  }

  public void unsetAdxType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ADXTYPE_ISSET_ID);
  }

  /** Returns true if field adxType is set (has been assigned a value) and false otherwise */
  public boolean isSetAdxType() {
    return EncodingUtils.testBit(__isset_bitfield, __ADXTYPE_ISSET_ID);
  }

  public void setAdxTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ADXTYPE_ISSET_ID, value);
  }

  public String getWinningKey() {
    return this.winningKey;
  }

  public TDbSync_Dsp_Winning_Key_Config setWinningKey(String winningKey) {
    this.winningKey = winningKey;
    return this;
  }

  public void unsetWinningKey() {
    this.winningKey = null;
  }

  /** Returns true if field winningKey is set (has been assigned a value) and false otherwise */
  public boolean isSetWinningKey() {
    return this.winningKey != null;
  }

  public void setWinningKeyIsSet(boolean value) {
    if (!value) {
      this.winningKey = null;
    }
  }

  public String getKeyVersion() {
    return this.keyVersion;
  }

  public TDbSync_Dsp_Winning_Key_Config setKeyVersion(String keyVersion) {
    this.keyVersion = keyVersion;
    return this;
  }

  public void unsetKeyVersion() {
    this.keyVersion = null;
  }

  /** Returns true if field keyVersion is set (has been assigned a value) and false otherwise */
  public boolean isSetKeyVersion() {
    return this.keyVersion != null;
  }

  public void setKeyVersionIsSet(boolean value) {
    if (!value) {
      this.keyVersion = null;
    }
  }

  public int getStatus() {
    return this.Status;
  }

  public TDbSync_Dsp_Winning_Key_Config setStatus(int Status) {
    this.Status = Status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field Status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public String getLastChanged() {
    return this.lastChanged;
  }

  public TDbSync_Dsp_Winning_Key_Config setLastChanged(String lastChanged) {
    this.lastChanged = lastChanged;
    return this;
  }

  public void unsetLastChanged() {
    this.lastChanged = null;
  }

  /** Returns true if field lastChanged is set (has been assigned a value) and false otherwise */
  public boolean isSetLastChanged() {
    return this.lastChanged != null;
  }

  public void setLastChangedIsSet(boolean value) {
    if (!value) {
      this.lastChanged = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ADX_TYPE:
      if (value == null) {
        unsetAdxType();
      } else {
        setAdxType((Integer)value);
      }
      break;

    case WINNING_KEY:
      if (value == null) {
        unsetWinningKey();
      } else {
        setWinningKey((String)value);
      }
      break;

    case KEY_VERSION:
      if (value == null) {
        unsetKeyVersion();
      } else {
        setKeyVersion((String)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Integer)value);
      }
      break;

    case LAST_CHANGED:
      if (value == null) {
        unsetLastChanged();
      } else {
        setLastChanged((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ADX_TYPE:
      return Integer.valueOf(getAdxType());

    case WINNING_KEY:
      return getWinningKey();

    case KEY_VERSION:
      return getKeyVersion();

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ADX_TYPE:
      return isSetAdxType();
    case WINNING_KEY:
      return isSetWinningKey();
    case KEY_VERSION:
      return isSetKeyVersion();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Winning_Key_Config)
      return this.equals((TDbSync_Dsp_Winning_Key_Config)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Winning_Key_Config that) {
    if (that == null)
      return false;

    boolean this_present_adxType = true;
    boolean that_present_adxType = true;
    if (this_present_adxType || that_present_adxType) {
      if (!(this_present_adxType && that_present_adxType))
        return false;
      if (this.adxType != that.adxType)
        return false;
    }

    boolean this_present_winningKey = true && this.isSetWinningKey();
    boolean that_present_winningKey = true && that.isSetWinningKey();
    if (this_present_winningKey || that_present_winningKey) {
      if (!(this_present_winningKey && that_present_winningKey))
        return false;
      if (!this.winningKey.equals(that.winningKey))
        return false;
    }

    boolean this_present_keyVersion = true && this.isSetKeyVersion();
    boolean that_present_keyVersion = true && that.isSetKeyVersion();
    if (this_present_keyVersion || that_present_keyVersion) {
      if (!(this_present_keyVersion && that_present_keyVersion))
        return false;
      if (!this.keyVersion.equals(that.keyVersion))
        return false;
    }

    boolean this_present_Status = true;
    boolean that_present_Status = true;
    if (this_present_Status || that_present_Status) {
      if (!(this_present_Status && that_present_Status))
        return false;
      if (this.Status != that.Status)
        return false;
    }

    boolean this_present_lastChanged = true && this.isSetLastChanged();
    boolean that_present_lastChanged = true && that.isSetLastChanged();
    if (this_present_lastChanged || that_present_lastChanged) {
      if (!(this_present_lastChanged && that_present_lastChanged))
        return false;
      if (!this.lastChanged.equals(that.lastChanged))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Winning_Key_Config other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAdxType()).compareTo(other.isSetAdxType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAdxType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.adxType, other.adxType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWinningKey()).compareTo(other.isSetWinningKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWinningKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.winningKey, other.winningKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetKeyVersion()).compareTo(other.isSetKeyVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKeyVersion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.keyVersion, other.keyVersion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Status, other.Status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastChanged()).compareTo(other.isSetLastChanged());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastChanged()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastChanged, other.lastChanged);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Winning_Key_Config(");
    boolean first = true;

    sb.append("adxType:");
    sb.append(this.adxType);
    first = false;
    if (!first) sb.append(", ");
    sb.append("winningKey:");
    if (this.winningKey == null) {
      sb.append("null");
    } else {
      sb.append(this.winningKey);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("keyVersion:");
    if (this.keyVersion == null) {
      sb.append("null");
    } else {
      sb.append(this.keyVersion);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Status:");
    sb.append(this.Status);
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastChanged:");
    if (this.lastChanged == null) {
      sb.append("null");
    } else {
      sb.append(this.lastChanged);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'adxType' because it's a primitive and you chose the non-beans generator.
    if (winningKey == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'winningKey' was not present! Struct: " + toString());
    }
    if (keyVersion == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'keyVersion' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'Status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TDbSync_Dsp_Winning_Key_ConfigStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Winning_Key_ConfigStandardScheme getScheme() {
      return new TDbSync_Dsp_Winning_Key_ConfigStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Winning_Key_ConfigStandardScheme extends StandardScheme<TDbSync_Dsp_Winning_Key_Config> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Winning_Key_Config struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ADX_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.adxType = iprot.readI32();
              struct.setAdxTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // WINNING_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.winningKey = iprot.readString();
              struct.setWinningKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // KEY_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.keyVersion = iprot.readString();
              struct.setKeyVersionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LAST_CHANGED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.lastChanged = iprot.readString();
              struct.setLastChangedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetAdxType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'adxType' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'Status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Winning_Key_Config struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ADX_TYPE_FIELD_DESC);
      oprot.writeI32(struct.adxType);
      oprot.writeFieldEnd();
      if (struct.winningKey != null) {
        oprot.writeFieldBegin(WINNING_KEY_FIELD_DESC);
        oprot.writeString(struct.winningKey);
        oprot.writeFieldEnd();
      }
      if (struct.keyVersion != null) {
        oprot.writeFieldBegin(KEY_VERSION_FIELD_DESC);
        oprot.writeString(struct.keyVersion);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.Status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Winning_Key_ConfigTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Winning_Key_ConfigTupleScheme getScheme() {
      return new TDbSync_Dsp_Winning_Key_ConfigTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Winning_Key_ConfigTupleScheme extends TupleScheme<TDbSync_Dsp_Winning_Key_Config> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Winning_Key_Config struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.adxType);
      oprot.writeString(struct.winningKey);
      oprot.writeString(struct.keyVersion);
      oprot.writeI32(struct.Status);
      oprot.writeString(struct.lastChanged);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Winning_Key_Config struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.adxType = iprot.readI32();
      struct.setAdxTypeIsSet(true);
      struct.winningKey = iprot.readString();
      struct.setWinningKeyIsSet(true);
      struct.keyVersion = iprot.readString();
      struct.setKeyVersionIsSet(true);
      struct.Status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
    }
  }

}

