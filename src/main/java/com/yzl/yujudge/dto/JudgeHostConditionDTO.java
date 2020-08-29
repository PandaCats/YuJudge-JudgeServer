package com.yzl.yujudge.dto;


/**
 * @author yuzhanglong
 * @description 描述判题服务器状态的视图层对象
 * @date 2020-8-17 19:42:07
 */
public class JudgeHostConditionDTO {
    private String workPath;
    private String scriptPath;
    private String resolutionPath;
    private Integer port;
    private Integer workingAmount;
    private Integer cpuCoreAmount;
    private Integer memoryCostPercentage;
    private Integer cpuCostPercentage;
    private Integer queueAmount;
    private Integer maxWorkingAmount;

    public Integer getMaxWorkingAmount() {
        return maxWorkingAmount;
    }

    public void setMaxWorkingAmount(Integer maxWorkingAmount) {
        this.maxWorkingAmount = maxWorkingAmount;
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath;
    }

    public String getScriptPath() {
        return scriptPath;
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    public String getResolutionPath() {
        return resolutionPath;
    }

    public void setResolutionPath(String resolutionPath) {
        this.resolutionPath = resolutionPath;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getWorkingAmount() {
        return workingAmount;
    }

    public void setWorkingAmount(Integer workingAmount) {
        this.workingAmount = workingAmount;
    }

    public Integer getCpuCoreAmount() {
        return cpuCoreAmount;
    }

    public void setCpuCoreAmount(Integer cpuCoreAmount) {
        this.cpuCoreAmount = cpuCoreAmount;
    }

    public Integer getMemoryCostPercentage() {
        return memoryCostPercentage;
    }

    public void setMemoryCostPercentage(Integer memoryCostPercentage) {
        this.memoryCostPercentage = memoryCostPercentage;
    }

    public Integer getCpuCostPercentage() {
        return cpuCostPercentage;
    }

    public void setCpuCostPercentage(Integer cpuCostPercentage) {
        this.cpuCostPercentage = cpuCostPercentage;
    }

    public Integer getQueueAmount() {
        return queueAmount;
    }

    public void setQueueAmount(Integer queueAmount) {
        this.queueAmount = queueAmount;
    }

    @Override
    public String toString() {
        return "JudgeHostConditionDTO{" +
                "workPath='" + workPath + '\'' +
                ", scriptPath='" + scriptPath + '\'' +
                ", resolutionPath='" + resolutionPath + '\'' +
                ", port=" + port +
                ", workingAmount=" + workingAmount +
                ", cpuCoreAmount=" + cpuCoreAmount +
                ", memoryCostPercentage=" + memoryCostPercentage +
                ", cpuCostPercentage=" + cpuCostPercentage +
                ", queueAmount=" + queueAmount +
                '}';
    }
}
