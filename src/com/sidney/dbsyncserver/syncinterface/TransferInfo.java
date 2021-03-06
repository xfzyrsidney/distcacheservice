/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sidney.dbsyncserver.syncinterface;

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

public class TransferInfo implements org.apache.thrift.TBase<TransferInfo, TransferInfo._Fields>, java.io.Serializable, Cloneable, Comparable<TransferInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TransferInfo");

  private static final org.apache.thrift.protocol.TField VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("version", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField CLIENTINFO_FIELD_DESC = new org.apache.thrift.protocol.TField("clientinfo", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("data", org.apache.thrift.protocol.TType.STRUCT, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TransferInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TransferInfoTupleSchemeFactory());
  }

  public long version; // required
  public long type; // required
  public long status; // required
  public ClientInfo clientinfo; // optional
  public BinaryData data; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    VERSION((short)1, "version"),
    TYPE((short)2, "type"),
    STATUS((short)3, "status"),
    CLIENTINFO((short)4, "clientinfo"),
    DATA((short)5, "data");

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
        case 1: // VERSION
          return VERSION;
        case 2: // TYPE
          return TYPE;
        case 3: // STATUS
          return STATUS;
        case 4: // CLIENTINFO
          return CLIENTINFO;
        case 5: // DATA
          return DATA;
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
  private static final int __VERSION_ISSET_ID = 0;
  private static final int __TYPE_ISSET_ID = 1;
  private static final int __STATUS_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.CLIENTINFO,_Fields.DATA};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.VERSION, new org.apache.thrift.meta_data.FieldMetaData("version", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.CLIENTINFO, new org.apache.thrift.meta_data.FieldMetaData("clientinfo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ClientInfo.class)));
    tmpMap.put(_Fields.DATA, new org.apache.thrift.meta_data.FieldMetaData("data", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BinaryData.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TransferInfo.class, metaDataMap);
  }

  public TransferInfo() {
  }

  public TransferInfo(
    long version,
    long type,
    long status)
  {
    this();
    this.version = version;
    setVersionIsSet(true);
    this.type = type;
    setTypeIsSet(true);
    this.status = status;
    setStatusIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TransferInfo(TransferInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    this.version = other.version;
    this.type = other.type;
    this.status = other.status;
    if (other.isSetClientinfo()) {
      this.clientinfo = new ClientInfo(other.clientinfo);
    }
    if (other.isSetData()) {
      this.data = new BinaryData(other.data);
    }
  }

  public TransferInfo deepCopy() {
    return new TransferInfo(this);
  }

  @Override
  public void clear() {
    setVersionIsSet(false);
    this.version = 0;
    setTypeIsSet(false);
    this.type = 0;
    setStatusIsSet(false);
    this.status = 0;
    this.clientinfo = null;
    this.data = null;
  }

  public long getVersion() {
    return this.version;
  }

  public TransferInfo setVersion(long version) {
    this.version = version;
    setVersionIsSet(true);
    return this;
  }

  public void unsetVersion() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __VERSION_ISSET_ID);
  }

  /** Returns true if field version is set (has been assigned a value) and false otherwise */
  public boolean isSetVersion() {
    return EncodingUtils.testBit(__isset_bitfield, __VERSION_ISSET_ID);
  }

  public void setVersionIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __VERSION_ISSET_ID, value);
  }

  public long getType() {
    return this.type;
  }

  public TransferInfo setType(long type) {
    this.type = type;
    setTypeIsSet(true);
    return this;
  }

  public void unsetType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TYPE_ISSET_ID);
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return EncodingUtils.testBit(__isset_bitfield, __TYPE_ISSET_ID);
  }

  public void setTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TYPE_ISSET_ID, value);
  }

  public long getStatus() {
    return this.status;
  }

  public TransferInfo setStatus(long status) {
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

  public ClientInfo getClientinfo() {
    return this.clientinfo;
  }

  public TransferInfo setClientinfo(ClientInfo clientinfo) {
    this.clientinfo = clientinfo;
    return this;
  }

  public void unsetClientinfo() {
    this.clientinfo = null;
  }

  /** Returns true if field clientinfo is set (has been assigned a value) and false otherwise */
  public boolean isSetClientinfo() {
    return this.clientinfo != null;
  }

  public void setClientinfoIsSet(boolean value) {
    if (!value) {
      this.clientinfo = null;
    }
  }

  public BinaryData getData() {
    return this.data;
  }

  public TransferInfo setData(BinaryData data) {
    this.data = data;
    return this;
  }

  public void unsetData() {
    this.data = null;
  }

  /** Returns true if field data is set (has been assigned a value) and false otherwise */
  public boolean isSetData() {
    return this.data != null;
  }

  public void setDataIsSet(boolean value) {
    if (!value) {
      this.data = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case VERSION:
      if (value == null) {
        unsetVersion();
      } else {
        setVersion((Long)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((Long)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Long)value);
      }
      break;

    case CLIENTINFO:
      if (value == null) {
        unsetClientinfo();
      } else {
        setClientinfo((ClientInfo)value);
      }
      break;

    case DATA:
      if (value == null) {
        unsetData();
      } else {
        setData((BinaryData)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case VERSION:
      return Long.valueOf(getVersion());

    case TYPE:
      return Long.valueOf(getType());

    case STATUS:
      return Long.valueOf(getStatus());

    case CLIENTINFO:
      return getClientinfo();

    case DATA:
      return getData();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case VERSION:
      return isSetVersion();
    case TYPE:
      return isSetType();
    case STATUS:
      return isSetStatus();
    case CLIENTINFO:
      return isSetClientinfo();
    case DATA:
      return isSetData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TransferInfo)
      return this.equals((TransferInfo)that);
    return false;
  }

  public boolean equals(TransferInfo that) {
    if (that == null)
      return false;

    boolean this_present_version = true;
    boolean that_present_version = true;
    if (this_present_version || that_present_version) {
      if (!(this_present_version && that_present_version))
        return false;
      if (this.version != that.version)
        return false;
    }

    boolean this_present_type = true;
    boolean that_present_type = true;
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (this.type != that.type)
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

    boolean this_present_clientinfo = true && this.isSetClientinfo();
    boolean that_present_clientinfo = true && that.isSetClientinfo();
    if (this_present_clientinfo || that_present_clientinfo) {
      if (!(this_present_clientinfo && that_present_clientinfo))
        return false;
      if (!this.clientinfo.equals(that.clientinfo))
        return false;
    }

    boolean this_present_data = true && this.isSetData();
    boolean that_present_data = true && that.isSetData();
    if (this_present_data || that_present_data) {
      if (!(this_present_data && that_present_data))
        return false;
      if (!this.data.equals(that.data))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TransferInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetVersion()).compareTo(other.isSetVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVersion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.version, other.version);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
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
    lastComparison = Boolean.valueOf(isSetClientinfo()).compareTo(other.isSetClientinfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClientinfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clientinfo, other.clientinfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData()).compareTo(other.isSetData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data, other.data);
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
    StringBuilder sb = new StringBuilder("TransferInfo(");
    boolean first = true;

    sb.append("version:");
    sb.append(this.version);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    sb.append(this.type);
    first = false;
    if (!first) sb.append(", ");
    sb.append("status:");
    sb.append(this.status);
    first = false;
    if (isSetClientinfo()) {
      if (!first) sb.append(", ");
      sb.append("clientinfo:");
      if (this.clientinfo == null) {
        sb.append("null");
      } else {
        sb.append(this.clientinfo);
      }
      first = false;
    }
    if (isSetData()) {
      if (!first) sb.append(", ");
      sb.append("data:");
      if (this.data == null) {
        sb.append("null");
      } else {
        sb.append(this.data);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'version' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'type' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
    if (clientinfo != null) {
      clientinfo.validate();
    }
    if (data != null) {
      data.validate();
    }
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

  private static class TransferInfoStandardSchemeFactory implements SchemeFactory {
    public TransferInfoStandardScheme getScheme() {
      return new TransferInfoStandardScheme();
    }
  }

  private static class TransferInfoStandardScheme extends StandardScheme<TransferInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TransferInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.version = iprot.readI64();
              struct.setVersionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.type = iprot.readI64();
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.status = iprot.readI64();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CLIENTINFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.clientinfo = new ClientInfo();
              struct.clientinfo.read(iprot);
              struct.setClientinfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.data = new BinaryData();
              struct.data.read(iprot);
              struct.setDataIsSet(true);
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
      if (!struct.isSetVersion()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'version' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'type' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TransferInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(VERSION_FIELD_DESC);
      oprot.writeI64(struct.version);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TYPE_FIELD_DESC);
      oprot.writeI64(struct.type);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI64(struct.status);
      oprot.writeFieldEnd();
      if (struct.clientinfo != null) {
        if (struct.isSetClientinfo()) {
          oprot.writeFieldBegin(CLIENTINFO_FIELD_DESC);
          struct.clientinfo.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.data != null) {
        if (struct.isSetData()) {
          oprot.writeFieldBegin(DATA_FIELD_DESC);
          struct.data.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TransferInfoTupleSchemeFactory implements SchemeFactory {
    public TransferInfoTupleScheme getScheme() {
      return new TransferInfoTupleScheme();
    }
  }

  private static class TransferInfoTupleScheme extends TupleScheme<TransferInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TransferInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI64(struct.version);
      oprot.writeI64(struct.type);
      oprot.writeI64(struct.status);
      BitSet optionals = new BitSet();
      if (struct.isSetClientinfo()) {
        optionals.set(0);
      }
      if (struct.isSetData()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetClientinfo()) {
        struct.clientinfo.write(oprot);
      }
      if (struct.isSetData()) {
        struct.data.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TransferInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.version = iprot.readI64();
      struct.setVersionIsSet(true);
      struct.type = iprot.readI64();
      struct.setTypeIsSet(true);
      struct.status = iprot.readI64();
      struct.setStatusIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.clientinfo = new ClientInfo();
        struct.clientinfo.read(iprot);
        struct.setClientinfoIsSet(true);
      }
      if (incoming.get(1)) {
        struct.data = new BinaryData();
        struct.data.read(iprot);
        struct.setDataIsSet(true);
      }
    }
  }

}

