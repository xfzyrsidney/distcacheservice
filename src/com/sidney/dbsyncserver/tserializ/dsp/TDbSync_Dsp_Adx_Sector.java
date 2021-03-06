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

public class TDbSync_Dsp_Adx_Sector implements org.apache.thrift.TBase<TDbSync_Dsp_Adx_Sector, TDbSync_Dsp_Adx_Sector._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Adx_Sector> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Adx_Sector");

  private static final org.apache.thrift.protocol.TField ADX_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("adxType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SECTOR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sectorID", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SECTOR_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("sectorName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField SECTOR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("sectorCode", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Adx_SectorStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Adx_SectorTupleSchemeFactory());
  }

  public int adxType; // required
  public int sectorID; // required
  public String sectorName; // required
  public String sectorCode; // required
  public int status; // required
  public String lastChanged; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ADX_TYPE((short)1, "adxType"),
    SECTOR_ID((short)2, "sectorID"),
    SECTOR_NAME((short)3, "sectorName"),
    SECTOR_CODE((short)4, "sectorCode"),
    STATUS((short)5, "status"),
    LAST_CHANGED((short)6, "lastChanged");

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
        case 2: // SECTOR_ID
          return SECTOR_ID;
        case 3: // SECTOR_NAME
          return SECTOR_NAME;
        case 4: // SECTOR_CODE
          return SECTOR_CODE;
        case 5: // STATUS
          return STATUS;
        case 6: // LAST_CHANGED
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
  private static final int __SECTORID_ISSET_ID = 1;
  private static final int __STATUS_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ADX_TYPE, new org.apache.thrift.meta_data.FieldMetaData("adxType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SECTOR_ID, new org.apache.thrift.meta_data.FieldMetaData("sectorID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SECTOR_NAME, new org.apache.thrift.meta_data.FieldMetaData("sectorName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SECTOR_CODE, new org.apache.thrift.meta_data.FieldMetaData("sectorCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Adx_Sector.class, metaDataMap);
  }

  public TDbSync_Dsp_Adx_Sector() {
  }

  public TDbSync_Dsp_Adx_Sector(
    int adxType,
    int sectorID,
    String sectorName,
    String sectorCode,
    int status,
    String lastChanged)
  {
    this();
    this.adxType = adxType;
    setAdxTypeIsSet(true);
    this.sectorID = sectorID;
    setSectorIDIsSet(true);
    this.sectorName = sectorName;
    this.sectorCode = sectorCode;
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Adx_Sector(TDbSync_Dsp_Adx_Sector other) {
    __isset_bitfield = other.__isset_bitfield;
    this.adxType = other.adxType;
    this.sectorID = other.sectorID;
    if (other.isSetSectorName()) {
      this.sectorName = other.sectorName;
    }
    if (other.isSetSectorCode()) {
      this.sectorCode = other.sectorCode;
    }
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
  }

  public TDbSync_Dsp_Adx_Sector deepCopy() {
    return new TDbSync_Dsp_Adx_Sector(this);
  }

  @Override
  public void clear() {
    setAdxTypeIsSet(false);
    this.adxType = 0;
    setSectorIDIsSet(false);
    this.sectorID = 0;
    this.sectorName = null;
    this.sectorCode = null;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
  }

  public int getAdxType() {
    return this.adxType;
  }

  public TDbSync_Dsp_Adx_Sector setAdxType(int adxType) {
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

  public int getSectorID() {
    return this.sectorID;
  }

  public TDbSync_Dsp_Adx_Sector setSectorID(int sectorID) {
    this.sectorID = sectorID;
    setSectorIDIsSet(true);
    return this;
  }

  public void unsetSectorID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SECTORID_ISSET_ID);
  }

  /** Returns true if field sectorID is set (has been assigned a value) and false otherwise */
  public boolean isSetSectorID() {
    return EncodingUtils.testBit(__isset_bitfield, __SECTORID_ISSET_ID);
  }

  public void setSectorIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SECTORID_ISSET_ID, value);
  }

  public String getSectorName() {
    return this.sectorName;
  }

  public TDbSync_Dsp_Adx_Sector setSectorName(String sectorName) {
    this.sectorName = sectorName;
    return this;
  }

  public void unsetSectorName() {
    this.sectorName = null;
  }

  /** Returns true if field sectorName is set (has been assigned a value) and false otherwise */
  public boolean isSetSectorName() {
    return this.sectorName != null;
  }

  public void setSectorNameIsSet(boolean value) {
    if (!value) {
      this.sectorName = null;
    }
  }

  public String getSectorCode() {
    return this.sectorCode;
  }

  public TDbSync_Dsp_Adx_Sector setSectorCode(String sectorCode) {
    this.sectorCode = sectorCode;
    return this;
  }

  public void unsetSectorCode() {
    this.sectorCode = null;
  }

  /** Returns true if field sectorCode is set (has been assigned a value) and false otherwise */
  public boolean isSetSectorCode() {
    return this.sectorCode != null;
  }

  public void setSectorCodeIsSet(boolean value) {
    if (!value) {
      this.sectorCode = null;
    }
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_Dsp_Adx_Sector setStatus(int status) {
    this.status = status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public String getLastChanged() {
    return this.lastChanged;
  }

  public TDbSync_Dsp_Adx_Sector setLastChanged(String lastChanged) {
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

    case SECTOR_ID:
      if (value == null) {
        unsetSectorID();
      } else {
        setSectorID((Integer)value);
      }
      break;

    case SECTOR_NAME:
      if (value == null) {
        unsetSectorName();
      } else {
        setSectorName((String)value);
      }
      break;

    case SECTOR_CODE:
      if (value == null) {
        unsetSectorCode();
      } else {
        setSectorCode((String)value);
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

    case SECTOR_ID:
      return Integer.valueOf(getSectorID());

    case SECTOR_NAME:
      return getSectorName();

    case SECTOR_CODE:
      return getSectorCode();

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
    case SECTOR_ID:
      return isSetSectorID();
    case SECTOR_NAME:
      return isSetSectorName();
    case SECTOR_CODE:
      return isSetSectorCode();
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
    if (that instanceof TDbSync_Dsp_Adx_Sector)
      return this.equals((TDbSync_Dsp_Adx_Sector)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Adx_Sector that) {
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

    boolean this_present_sectorID = true;
    boolean that_present_sectorID = true;
    if (this_present_sectorID || that_present_sectorID) {
      if (!(this_present_sectorID && that_present_sectorID))
        return false;
      if (this.sectorID != that.sectorID)
        return false;
    }

    boolean this_present_sectorName = true && this.isSetSectorName();
    boolean that_present_sectorName = true && that.isSetSectorName();
    if (this_present_sectorName || that_present_sectorName) {
      if (!(this_present_sectorName && that_present_sectorName))
        return false;
      if (!this.sectorName.equals(that.sectorName))
        return false;
    }

    boolean this_present_sectorCode = true && this.isSetSectorCode();
    boolean that_present_sectorCode = true && that.isSetSectorCode();
    if (this_present_sectorCode || that_present_sectorCode) {
      if (!(this_present_sectorCode && that_present_sectorCode))
        return false;
      if (!this.sectorCode.equals(that.sectorCode))
        return false;
    }

    boolean this_present_status = true;
    boolean that_present_status = true;
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (this.status != that.status)
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
  public int compareTo(TDbSync_Dsp_Adx_Sector other) {
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
    lastComparison = Boolean.valueOf(isSetSectorID()).compareTo(other.isSetSectorID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSectorID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sectorID, other.sectorID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSectorName()).compareTo(other.isSetSectorName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSectorName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sectorName, other.sectorName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSectorCode()).compareTo(other.isSetSectorCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSectorCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sectorCode, other.sectorCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Adx_Sector(");
    boolean first = true;

    sb.append("adxType:");
    sb.append(this.adxType);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sectorID:");
    sb.append(this.sectorID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sectorName:");
    if (this.sectorName == null) {
      sb.append("null");
    } else {
      sb.append(this.sectorName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sectorCode:");
    if (this.sectorCode == null) {
      sb.append("null");
    } else {
      sb.append(this.sectorCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("status:");
    sb.append(this.status);
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
    // alas, we cannot check 'sectorID' because it's a primitive and you chose the non-beans generator.
    if (sectorName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sectorName' was not present! Struct: " + toString());
    }
    if (sectorCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sectorCode' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
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

  private static class TDbSync_Dsp_Adx_SectorStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Adx_SectorStandardScheme getScheme() {
      return new TDbSync_Dsp_Adx_SectorStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Adx_SectorStandardScheme extends StandardScheme<TDbSync_Dsp_Adx_Sector> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Adx_Sector struct) throws org.apache.thrift.TException {
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
          case 2: // SECTOR_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sectorID = iprot.readI32();
              struct.setSectorIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SECTOR_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sectorName = iprot.readString();
              struct.setSectorNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SECTOR_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sectorCode = iprot.readString();
              struct.setSectorCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // LAST_CHANGED
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
      if (!struct.isSetSectorID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'sectorID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Adx_Sector struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ADX_TYPE_FIELD_DESC);
      oprot.writeI32(struct.adxType);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(SECTOR_ID_FIELD_DESC);
      oprot.writeI32(struct.sectorID);
      oprot.writeFieldEnd();
      if (struct.sectorName != null) {
        oprot.writeFieldBegin(SECTOR_NAME_FIELD_DESC);
        oprot.writeString(struct.sectorName);
        oprot.writeFieldEnd();
      }
      if (struct.sectorCode != null) {
        oprot.writeFieldBegin(SECTOR_CODE_FIELD_DESC);
        oprot.writeString(struct.sectorCode);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
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

  private static class TDbSync_Dsp_Adx_SectorTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Adx_SectorTupleScheme getScheme() {
      return new TDbSync_Dsp_Adx_SectorTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Adx_SectorTupleScheme extends TupleScheme<TDbSync_Dsp_Adx_Sector> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Adx_Sector struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.adxType);
      oprot.writeI32(struct.sectorID);
      oprot.writeString(struct.sectorName);
      oprot.writeString(struct.sectorCode);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Adx_Sector struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.adxType = iprot.readI32();
      struct.setAdxTypeIsSet(true);
      struct.sectorID = iprot.readI32();
      struct.setSectorIDIsSet(true);
      struct.sectorName = iprot.readString();
      struct.setSectorNameIsSet(true);
      struct.sectorCode = iprot.readString();
      struct.setSectorCodeIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
    }
  }

}

