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

public class TDbSync_Dsp_Ad_Size implements org.apache.thrift.TBase<TDbSync_Dsp_Ad_Size, TDbSync_Dsp_Ad_Size._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Ad_Size> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Ad_Size");

  private static final org.apache.thrift.protocol.TField SIZE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sizeID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField SIZE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("sizeName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField WIDTH_FIELD_DESC = new org.apache.thrift.protocol.TField("width", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField HEIGHT_FIELD_DESC = new org.apache.thrift.protocol.TField("height", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Ad_SizeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Ad_SizeTupleSchemeFactory());
  }

  public int sizeID; // required
  public int status; // required
  public String lastChanged; // required
  public String sizeName; // required
  public int width; // required
  public int height; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SIZE_ID((short)1, "sizeID"),
    STATUS((short)2, "status"),
    LAST_CHANGED((short)3, "lastChanged"),
    SIZE_NAME((short)4, "sizeName"),
    WIDTH((short)5, "width"),
    HEIGHT((short)6, "height");

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
        case 1: // SIZE_ID
          return SIZE_ID;
        case 2: // STATUS
          return STATUS;
        case 3: // LAST_CHANGED
          return LAST_CHANGED;
        case 4: // SIZE_NAME
          return SIZE_NAME;
        case 5: // WIDTH
          return WIDTH;
        case 6: // HEIGHT
          return HEIGHT;
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
  private static final int __SIZEID_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private static final int __WIDTH_ISSET_ID = 2;
  private static final int __HEIGHT_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SIZE_ID, new org.apache.thrift.meta_data.FieldMetaData("sizeID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SIZE_NAME, new org.apache.thrift.meta_data.FieldMetaData("sizeName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.WIDTH, new org.apache.thrift.meta_data.FieldMetaData("width", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.HEIGHT, new org.apache.thrift.meta_data.FieldMetaData("height", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Ad_Size.class, metaDataMap);
  }

  public TDbSync_Dsp_Ad_Size() {
  }

  public TDbSync_Dsp_Ad_Size(
    int sizeID,
    int status,
    String lastChanged,
    String sizeName,
    int width,
    int height)
  {
    this();
    this.sizeID = sizeID;
    setSizeIDIsSet(true);
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.sizeName = sizeName;
    this.width = width;
    setWidthIsSet(true);
    this.height = height;
    setHeightIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Ad_Size(TDbSync_Dsp_Ad_Size other) {
    __isset_bitfield = other.__isset_bitfield;
    this.sizeID = other.sizeID;
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    if (other.isSetSizeName()) {
      this.sizeName = other.sizeName;
    }
    this.width = other.width;
    this.height = other.height;
  }

  public TDbSync_Dsp_Ad_Size deepCopy() {
    return new TDbSync_Dsp_Ad_Size(this);
  }

  @Override
  public void clear() {
    setSizeIDIsSet(false);
    this.sizeID = 0;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
    this.sizeName = null;
    setWidthIsSet(false);
    this.width = 0;
    setHeightIsSet(false);
    this.height = 0;
  }

  public int getSizeID() {
    return this.sizeID;
  }

  public TDbSync_Dsp_Ad_Size setSizeID(int sizeID) {
    this.sizeID = sizeID;
    setSizeIDIsSet(true);
    return this;
  }

  public void unsetSizeID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SIZEID_ISSET_ID);
  }

  /** Returns true if field sizeID is set (has been assigned a value) and false otherwise */
  public boolean isSetSizeID() {
    return EncodingUtils.testBit(__isset_bitfield, __SIZEID_ISSET_ID);
  }

  public void setSizeIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SIZEID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_Dsp_Ad_Size setStatus(int status) {
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

  public TDbSync_Dsp_Ad_Size setLastChanged(String lastChanged) {
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

  public String getSizeName() {
    return this.sizeName;
  }

  public TDbSync_Dsp_Ad_Size setSizeName(String sizeName) {
    this.sizeName = sizeName;
    return this;
  }

  public void unsetSizeName() {
    this.sizeName = null;
  }

  /** Returns true if field sizeName is set (has been assigned a value) and false otherwise */
  public boolean isSetSizeName() {
    return this.sizeName != null;
  }

  public void setSizeNameIsSet(boolean value) {
    if (!value) {
      this.sizeName = null;
    }
  }

  public int getWidth() {
    return this.width;
  }

  public TDbSync_Dsp_Ad_Size setWidth(int width) {
    this.width = width;
    setWidthIsSet(true);
    return this;
  }

  public void unsetWidth() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WIDTH_ISSET_ID);
  }

  /** Returns true if field width is set (has been assigned a value) and false otherwise */
  public boolean isSetWidth() {
    return EncodingUtils.testBit(__isset_bitfield, __WIDTH_ISSET_ID);
  }

  public void setWidthIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WIDTH_ISSET_ID, value);
  }

  public int getHeight() {
    return this.height;
  }

  public TDbSync_Dsp_Ad_Size setHeight(int height) {
    this.height = height;
    setHeightIsSet(true);
    return this;
  }

  public void unsetHeight() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HEIGHT_ISSET_ID);
  }

  /** Returns true if field height is set (has been assigned a value) and false otherwise */
  public boolean isSetHeight() {
    return EncodingUtils.testBit(__isset_bitfield, __HEIGHT_ISSET_ID);
  }

  public void setHeightIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HEIGHT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SIZE_ID:
      if (value == null) {
        unsetSizeID();
      } else {
        setSizeID((Integer)value);
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

    case SIZE_NAME:
      if (value == null) {
        unsetSizeName();
      } else {
        setSizeName((String)value);
      }
      break;

    case WIDTH:
      if (value == null) {
        unsetWidth();
      } else {
        setWidth((Integer)value);
      }
      break;

    case HEIGHT:
      if (value == null) {
        unsetHeight();
      } else {
        setHeight((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SIZE_ID:
      return Integer.valueOf(getSizeID());

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case SIZE_NAME:
      return getSizeName();

    case WIDTH:
      return Integer.valueOf(getWidth());

    case HEIGHT:
      return Integer.valueOf(getHeight());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SIZE_ID:
      return isSetSizeID();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case SIZE_NAME:
      return isSetSizeName();
    case WIDTH:
      return isSetWidth();
    case HEIGHT:
      return isSetHeight();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Ad_Size)
      return this.equals((TDbSync_Dsp_Ad_Size)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Ad_Size that) {
    if (that == null)
      return false;

    boolean this_present_sizeID = true;
    boolean that_present_sizeID = true;
    if (this_present_sizeID || that_present_sizeID) {
      if (!(this_present_sizeID && that_present_sizeID))
        return false;
      if (this.sizeID != that.sizeID)
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

    boolean this_present_sizeName = true && this.isSetSizeName();
    boolean that_present_sizeName = true && that.isSetSizeName();
    if (this_present_sizeName || that_present_sizeName) {
      if (!(this_present_sizeName && that_present_sizeName))
        return false;
      if (!this.sizeName.equals(that.sizeName))
        return false;
    }

    boolean this_present_width = true;
    boolean that_present_width = true;
    if (this_present_width || that_present_width) {
      if (!(this_present_width && that_present_width))
        return false;
      if (this.width != that.width)
        return false;
    }

    boolean this_present_height = true;
    boolean that_present_height = true;
    if (this_present_height || that_present_height) {
      if (!(this_present_height && that_present_height))
        return false;
      if (this.height != that.height)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Ad_Size other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSizeID()).compareTo(other.isSetSizeID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSizeID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sizeID, other.sizeID);
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
    lastComparison = Boolean.valueOf(isSetSizeName()).compareTo(other.isSetSizeName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSizeName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sizeName, other.sizeName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWidth()).compareTo(other.isSetWidth());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWidth()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.width, other.width);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHeight()).compareTo(other.isSetHeight());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHeight()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.height, other.height);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Ad_Size(");
    boolean first = true;

    sb.append("sizeID:");
    sb.append(this.sizeID);
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
    if (!first) sb.append(", ");
    sb.append("sizeName:");
    if (this.sizeName == null) {
      sb.append("null");
    } else {
      sb.append(this.sizeName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("width:");
    sb.append(this.width);
    first = false;
    if (!first) sb.append(", ");
    sb.append("height:");
    sb.append(this.height);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'sizeID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    if (sizeName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sizeName' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'width' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'height' because it's a primitive and you chose the non-beans generator.
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

  private static class TDbSync_Dsp_Ad_SizeStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Ad_SizeStandardScheme getScheme() {
      return new TDbSync_Dsp_Ad_SizeStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Ad_SizeStandardScheme extends StandardScheme<TDbSync_Dsp_Ad_Size> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Ad_Size struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SIZE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sizeID = iprot.readI32();
              struct.setSizeIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LAST_CHANGED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.lastChanged = iprot.readString();
              struct.setLastChangedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SIZE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sizeName = iprot.readString();
              struct.setSizeNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // WIDTH
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.width = iprot.readI32();
              struct.setWidthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // HEIGHT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.height = iprot.readI32();
              struct.setHeightIsSet(true);
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
      if (!struct.isSetSizeID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'sizeID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetWidth()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'width' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetHeight()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'height' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Ad_Size struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SIZE_ID_FIELD_DESC);
      oprot.writeI32(struct.sizeID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      if (struct.sizeName != null) {
        oprot.writeFieldBegin(SIZE_NAME_FIELD_DESC);
        oprot.writeString(struct.sizeName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(WIDTH_FIELD_DESC);
      oprot.writeI32(struct.width);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(HEIGHT_FIELD_DESC);
      oprot.writeI32(struct.height);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Ad_SizeTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Ad_SizeTupleScheme getScheme() {
      return new TDbSync_Dsp_Ad_SizeTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Ad_SizeTupleScheme extends TupleScheme<TDbSync_Dsp_Ad_Size> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Ad_Size struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.sizeID);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
      oprot.writeString(struct.sizeName);
      oprot.writeI32(struct.width);
      oprot.writeI32(struct.height);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Ad_Size struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.sizeID = iprot.readI32();
      struct.setSizeIDIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.sizeName = iprot.readString();
      struct.setSizeNameIsSet(true);
      struct.width = iprot.readI32();
      struct.setWidthIsSet(true);
      struct.height = iprot.readI32();
      struct.setHeightIsSet(true);
    }
  }

}

