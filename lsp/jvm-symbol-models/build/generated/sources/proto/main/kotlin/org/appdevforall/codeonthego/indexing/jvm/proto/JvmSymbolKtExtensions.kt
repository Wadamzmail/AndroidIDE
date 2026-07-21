package org.appdevforall.codeonthego.indexing.jvm.proto

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.ClassData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.EnumEntryData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.FieldData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.FunctionData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.JvmSourceLanguage
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.JvmSymbolData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.JvmSymbolKind
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.JvmVisibility
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.KotlinClassData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.KotlinFunctionData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.KotlinPropertyData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.KtFileData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.ParameterData
import org.appdevforall.codeonthego.indexing.jvm.proto.JvmSymbolProtos.TypeAliasData

public fun JvmSymbolData(
  name: String,
  shortName: String,
  packageName: String,
  sourceId: String,
  kind: JvmSymbolKind,
  language: JvmSourceLanguage,
  visibility: JvmVisibility,
  isDeprecated: Boolean,
  classData: ClassData?,
  functionData: FunctionData?,
  fieldData: FieldData?,
  enumEntryData: EnumEntryData?,
  typeAliasData: TypeAliasData?,
): JvmSymbolData {
  val _builder = JvmSymbolData.newBuilder().apply {
    setName(name)
    setShortName(shortName)
    setPackageName(packageName)
    setSourceId(sourceId)
    setKind(kind)
    setLanguage(language)
    setVisibility(visibility)
    setIsDeprecated(isDeprecated)
    classData?.let { setClassData(it) }
    functionData?.let { setFunctionData(it) }
    fieldData?.let { setFieldData(it) }
    enumEntryData?.let { setEnumEntryData(it) }
    typeAliasData?.let { setTypeAliasData(it) }
  }
  return _builder.build()
}

public fun ClassData(
  containingClassName: String,
  supertypeNamesList: List<String>,
  typeParametersList: List<String>,
  isAbstract: Boolean,
  isFinal: Boolean,
  isInner: Boolean,
  isStatic: Boolean,
  kotlin: KotlinClassData?,
): ClassData {
  val _builder = ClassData.newBuilder().apply {
    setContainingClassName(containingClassName)
    addAllSupertypeNames(supertypeNamesList)
    addAllTypeParameters(typeParametersList)
    setIsAbstract(isAbstract)
    setIsFinal(isFinal)
    setIsInner(isInner)
    setIsStatic(isStatic)
    kotlin?.let { setKotlin(it) }
  }
  return _builder.build()
}

public fun KotlinClassData(
  isData: Boolean,
  isValue: Boolean,
  isSealed: Boolean,
  isFunInterface: Boolean,
  isExpect: Boolean,
  isActual: Boolean,
  isExternal: Boolean,
  sealedSubclassesList: List<String>,
  companionObjectName: String,
): KotlinClassData {
  val _builder = KotlinClassData.newBuilder().apply {
    setIsData(isData)
    setIsValue(isValue)
    setIsSealed(isSealed)
    setIsFunInterface(isFunInterface)
    setIsExpect(isExpect)
    setIsActual(isActual)
    setIsExternal(isExternal)
    addAllSealedSubclasses(sealedSubclassesList)
    setCompanionObjectName(companionObjectName)
  }
  return _builder.build()
}

public fun FunctionData(
  containingClassName: String,
  returnTypeName: String,
  returnTypeDisplayName: String,
  parameterCount: Int,
  parametersList: List<ParameterData>,
  signatureDisplay: String,
  typeParametersList: List<String>,
  isStatic: Boolean,
  isAbstract: Boolean,
  isFinal: Boolean,
  kotlin: KotlinFunctionData?,
): FunctionData {
  val _builder = FunctionData.newBuilder().apply {
    setContainingClassName(containingClassName)
    setReturnTypeName(returnTypeName)
    setReturnTypeDisplayName(returnTypeDisplayName)
    setParameterCount(parameterCount)
    addAllParameters(parametersList)
    setSignatureDisplay(signatureDisplay)
    addAllTypeParameters(typeParametersList)
    setIsStatic(isStatic)
    setIsAbstract(isAbstract)
    setIsFinal(isFinal)
    kotlin?.let { setKotlin(it) }
  }
  return _builder.build()
}

public fun ParameterData(
  name: String,
  typeName: String,
  typeDisplayName: String,
  hasDefaultValue: Boolean,
  isCrossinline: Boolean,
  isNoinline: Boolean,
  isVararg: Boolean,
): ParameterData {
  val _builder = ParameterData.newBuilder().apply {
    setName(name)
    setTypeName(typeName)
    setTypeDisplayName(typeDisplayName)
    setHasDefaultValue(hasDefaultValue)
    setIsCrossinline(isCrossinline)
    setIsNoinline(isNoinline)
    setIsVararg(isVararg)
  }
  return _builder.build()
}

public fun KotlinFunctionData(
  receiverTypeName: String,
  receiverTypeDisplayName: String,
  isSuspend: Boolean,
  isInline: Boolean,
  isInfix: Boolean,
  isOperator: Boolean,
  isTailrec: Boolean,
  isExternal: Boolean,
  isExpect: Boolean,
  isActual: Boolean,
  isReturnTypeNullable: Boolean,
): KotlinFunctionData {
  val _builder = KotlinFunctionData.newBuilder().apply {
    setReceiverTypeName(receiverTypeName)
    setReceiverTypeDisplayName(receiverTypeDisplayName)
    setIsSuspend(isSuspend)
    setIsInline(isInline)
    setIsInfix(isInfix)
    setIsOperator(isOperator)
    setIsTailrec(isTailrec)
    setIsExternal(isExternal)
    setIsExpect(isExpect)
    setIsActual(isActual)
    setIsReturnTypeNullable(isReturnTypeNullable)
  }
  return _builder.build()
}

public fun FieldData(
  containingClassName: String,
  typeName: String,
  typeDisplayName: String,
  isStatic: Boolean,
  isFinal: Boolean,
  constantValue: String,
  kotlin: KotlinPropertyData?,
): FieldData {
  val _builder = FieldData.newBuilder().apply {
    setContainingClassName(containingClassName)
    setTypeName(typeName)
    setTypeDisplayName(typeDisplayName)
    setIsStatic(isStatic)
    setIsFinal(isFinal)
    setConstantValue(constantValue)
    kotlin?.let { setKotlin(it) }
  }
  return _builder.build()
}

public fun KotlinPropertyData(
  receiverTypeName: String,
  receiverTypeDisplayName: String,
  isConst: Boolean,
  isLateinit: Boolean,
  hasGetter: Boolean,
  hasSetter: Boolean,
  isDelegated: Boolean,
  isExpect: Boolean,
  isActual: Boolean,
  isExternal: Boolean,
  isTypeNullable: Boolean,
): KotlinPropertyData {
  val _builder = KotlinPropertyData.newBuilder().apply {
    setReceiverTypeName(receiverTypeName)
    setReceiverTypeDisplayName(receiverTypeDisplayName)
    setIsConst(isConst)
    setIsLateinit(isLateinit)
    setHasGetter(hasGetter)
    setHasSetter(hasSetter)
    setIsDelegated(isDelegated)
    setIsExpect(isExpect)
    setIsActual(isActual)
    setIsExternal(isExternal)
    setIsTypeNullable(isTypeNullable)
  }
  return _builder.build()
}

public fun EnumEntryData(containingEnumName: String, ordinal: Int): EnumEntryData {
  val _builder = EnumEntryData.newBuilder().apply {
    setContainingEnumName(containingEnumName)
    setOrdinal(ordinal)
  }
  return _builder.build()
}

public fun TypeAliasData(
  expandedTypeName: String,
  expandedTypeDisplayName: String,
  typeParametersList: List<String>,
): TypeAliasData {
  val _builder = TypeAliasData.newBuilder().apply {
    setExpandedTypeName(expandedTypeName)
    setExpandedTypeDisplayName(expandedTypeDisplayName)
    addAllTypeParameters(typeParametersList)
  }
  return _builder.build()
}

public fun KtFileData(
  path: String,
  packageFqName: String,
  lastModified: Long,
  modificationStamp: Long,
  indexed: Boolean,
  symbolKeysList: List<String>,
): KtFileData {
  val _builder = KtFileData.newBuilder().apply {
    setPath(path)
    setPackageFqName(packageFqName)
    setLastModified(lastModified)
    setModificationStamp(modificationStamp)
    setIndexed(indexed)
    addAllSymbolKeys(symbolKeysList)
  }
  return _builder.build()
}
