/*
 * Copyright 2015 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclairjs.nashorn;

import org.junit.Test;
import static org.junit.Assert.*;

import javax.script.Invocable;
import javax.script.ScriptEngine;

public class MlLibTest {

	@Test
    public void LinearRegressionExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("LinearRegressionWithSGDExample");
        
        String expected = "[{\"0\":34.802055592544406,\"1\":-0.4307829,\"length\":2}," +
                "{\"0\":32.26369105545771,\"1\":-0.1625189,\"length\":2}," +
                "{\"0\":27.073768640300933,\"1\":-0.1625189,\"length\":2}," +
                "{\"0\":32.956369807610656,\"1\":-0.1625189,\"length\":2}," +
                "{\"0\":26.589176152816094,\"1\":0.3715636,\"length\":2}," +
                "{\"0\":34.161678328568854,\"1\":0.7654678,\"length\":2}," +
                "{\"0\":24.3647041765334,\"1\":0.8544153,\"length\":2}," +
                "{\"0\":26.661937949806784,\"1\":1.2669476,\"length\":2}," +
                "{\"0\":28.790597957841044,\"1\":1.2669476,\"length\":2}," +
                "{\"0\":20.51350661135643,\"1\":1.2669476,\"length\":2}]";
        assertEquals("failure - strings are not equal", expected, ret);

    }

    /*
        tests
        SparkContext.parallelize([FreqItemset])
        FreqItemset()
        AssociationRules()
        AssociationRules.setMinConfidence()
        AssociationRules.run()
        Rule.antecedent()
        Rule.consequent()
        Rule.confidence()
        RDD.collect()
     */
    @Test
    public void AssociationRulesTest() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("AssociationRulesTest");

        String expected = "[{\"antecedent\":[\"a\"],\"consequent\":[\"b\"],\"confidence\":0.8}]";
        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
            tests
            Vectors.dense
            BisectingKMeans()
            BisectingKMeans.setK()
            BisectingKMeans.run()
            BisectingKMeansModel()
            BisectingKMeansModel.computeCost()
            BisectingKMeansModel.clusterCenters()
     */
    @Test
    public void BisectingKMeansExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("BisectingKMeansExample");

        String expected = "passed";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }
    /*
            tests
            MLUtils.loadLibSVMFile()
            RDD.randomSplit()
            DecisionTree.trainClassifier()
            DecisionTreeModel()
            LabeledPoint.getLabel()
            LabeledPoint.getFeatures()

     */
    @Test
    public void DecisionTreeClassificationExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("DecisionTreeClassificationExample");

        String expected = "successful";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
           tests
           MLUtils.loadLibSVMFile()
           RDD.randomSplit()
           DecisionTree.trainRegressor()
           DecisionTreeModel()
           LabeledPoint.getLabel()
           LabeledPoint.getFeatures()

    */
    @Test
    public void DecisionTreeRegressionExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("DecisionTreeRegressionExample");

        String expected = "successful";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
           tests
           FPGrowth()
           FPGrowth.setMinSupport()
           FPGrowth.setNumPartitions()
           FPGrowth.run()
           FPGrowthModel()
           FPGrowthModel.freqItemsets()
           FreqItemset()
           FreqItemset.items()
           FreqItemset.freq()
           List()

    */
    @Test
    public void fpGrowthExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("fpGrowthExample");

        String expected = "[{\"freq\":3,\"items\":[\"s\"]},{\"freq\":3,\"items\":[\"s\",\"x\"]},{\"freq\":2,\"items\":[\"s\",\"x\",\"z\"]}]";

        assertEquals("failure - strings are not equal", expected, ret);

    }
    /*
               tests
               MLUtils.loadLibSVMFile()
               RDD.randomSplit()
               BoostingStrategy.defaultParams("Classification")
               BoostingStrategy.setNumIterations()
               BoostingStrategy.getTreeStrategy()
               Strategy.setMaxDepth()
               Strategy.setNumClasses()
               Strategy.setCategoricalFeaturesInfo()
               GradientBoostedTrees.train()
               GradientBoostedTreesModel.predict(Vector)
               GradientBoostedTreesModel.toString()
               GradientBoostedTreesModel.toDebugString()
               GradientBoostedTreesModel.load()
               GradientBoostedTreesModel.save()
               LabeledPoint.getLabel()
               LabeledPoint.getFeatures()

    */
    @Test
    public void GradientBoostingClassificationExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("GradientBoostingClassificationExample");

        String expected = "successful";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
               tests
               MLUtils.loadLibSVMFile()
               RDD.randomSplit()
               BoostingStrategy.defaultParams("Regression")
               BoostingStrategy.setNumIterations()
               BoostingStrategy.getTreeStrategy()
               Strategy.setMaxDepth()
               Strategy.setCategoricalFeaturesInfo()
               GradientBoostedTrees.train()
               GradientBoostedTreesModel.predict(Vector)
               GradientBoostedTreesModel.toString()
               GradientBoostedTreesModel.toDebugString()
               GradientBoostedTreesModel.load()
               GradientBoostedTreesModel.save()
               LabeledPoint.getLabel()
               LabeledPoint.getFeatures()

    */
    @Test
    public void GradientBoostingRegressionExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("GradientBoostingRegressionExample");

        String expected = "successful";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }
    /*
           tests
           RDD.randomSplit()
           IsotonicRegression()
           IsotonicRegression.setIsotonic()
           IsotonicRegression.run()
           IsotonicRegressionModel()
           IsotonicRegressionModel.predict()
           IsotonicRegressionModel.save()
           IsotonicRegressionModel.load()
           FloatRDD()
           FloatRDD.mean()
           Tuple()
        */
    @Test
    public void IsotonicRegressionExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("IsotonicRegressionExample");

        String expected = "{\"meanSquaredError\":0.008860256490591363}";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }
        /*
            Tests
            KMeans.train();
            KMeansModel.clusterCenters();
            KMeansModel.computeCost(points);
         */
    @Test
    public void KMeansExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("KMeansExample");

        String expected = "all is good";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        LogisticRegressionWithLBFGS()
        LogisticRegressionWithLBFGS.setNumClasses()
        LogisticRegressionWithLBFGS.run()
        LogisticRegressionWithLBFGSModel.predict()
        BinaryClassificationMetrics()
        BinaryClassificationMetrics.precisionByThreshold()
        BinaryClassificationMetrics.recallByThreshold()
        BinaryClassificationMetrics.fMeasureByThreshold()
        BinaryClassificationMetrics.pr()
     */
    @Test
    public void BinaryClassificationMetricsExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("binaryClassificationMetricsExample");

        String expected = "all is good";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        tests
        MLUtils.loadLibSVMFile()
        MLUtils.appendBias()
        RDD.sample()
        RDD.subtract()
        LBFGS.runLBFGS()
        LogisticGradient()
        SquaredL2Updater()
        LogisticRegressionModel()
        LogisticRegressionModel.clearThreshold()
        BinaryClassificationMetrics()
        BinaryClassificationMetrics.areaUnderROC

     */

    @Test
    public void lbfgsExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("lbfgsExample");

        String expected = "0.5";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        RDD.zipWithIndex()
        PairRDD.fromRDD()
        LDA()
        LDA.setK()
        LDA.run()
        DistributedLDAModel.vocabSize()
        DistributedLDAModel.topicsMatrix()
        DenseMatrix.apply()

     */
    @Test
    public void ldaExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("ldaExample");

        String expected = "11";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        LogisticRegressionWithSGD.train()
        LogisticRegressionModel.weights()
     */

    @Test
    public void lrExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("lrExample");

        String expected = "{\"type\":1,\"values\":[0.9550072129824428,0.7533138476702799]}";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        LogisticRegressionWithLBFGS()
        LogisticRegressionWithLBFGS.setNumClasses()
        LogisticRegressionWithLBFGS.run(training)
        LogisticRegressionModel.predict()
        LogisticRegressionModel.save()
        LogisticRegressionModel.load()
        MulticlassMetrics()
        MulticlassMetrics.confusionMatrix()
        MulticlassMetrics.precision());
        MulticlassMetrics.recall());
        MulticlassMetrics.fMeasure());
        MulticlassMetrics.weightedPrecision());
        MulticlassMetrics.weightedRecall());
        MulticlassMetrics.weightedFMeasure());
        MulticlassMetrics.weightedFalsePositiveRate());
      */

    @Test
    public void multiclassClassificationMetricsExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("multiclassClassificationMetricsExample");

        String expected = "0.04391931170794093";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        RandomRDDs.normalRDD
        RandomRDDs.normalVectorRDD
     */
    @Test
    public void RandomRDDGenerationExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("RandomRDDGenerationExample");

        String expected = "all is good";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        MultilabelMetrics()
        MultilabelMetrics.recall()
        MultilabelMetrics.precision());
        MultilabelMetrics.f1Measure());
        MultilabelMetrics.accuracy());
        MultilabelMetrics.labels()
        MultilabelMetrics.precision(metrics.labels()[i]));
        MultilabelMetrics.recall(metrics.labels()[i]));
        MultilabelMetrics.f1Measure(metrics.labels()[i]));
        MultilabelMetrics.microRecall());
        MultilabelMetrics.microPrecision());
        MultilabelMetrics.microF1Measure());
        MultilabelMetrics.hammingLoss());
        MultilabelMetrics.subsetAccuracy());
     */

    @Test
    public void multilabelClassificationMetricsExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("multilabelClassificationMetricsExample");

        String expected = "0.3333333333333333";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        NaiveBayes.train()
        NaiveBayes.load()
        NaiveBayesModel.predict()
        NaiveBayesModel.save()
     */


    @Test
    public void naiveBayesExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("naiveBayesExample");

        String expected = "0.975609756097561";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
            RowMatrix()
            RowMatrix.computePrincipalComponents()
            RowMatrix.multiply()
            RowMatrix.rows()

     */

    @Test
    public void pcaExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("pcaExample");

        assertEquals("failure - strings are not equal", "passed", ret.toString());

    }

    /*
        PowerIterationClustering()
        PowerIterationClustering.setK()
        PowerIterationClustering.setMaxIterations();
        PowerIterationClustering.run();
        PowerIterationClusteringModel.assignments()
        PowerIterationClusteringAssignment.id()
        PowerIterationClusteringAssignment.cluster()
     */

    @Test
    public void PowerIterationClusteringExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("PowerIterationClusteringExample");

        String expected = "passed";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        PrefixSpan()
        PrefixSpan.setMinSupport()
        PrefixSpan.setMaxPatternLength();
        PrefixSpan.run();
        PrefixSpanModel.freqSequences()
        PrefixSpanFreqSequence.sequence()
        PrefixSpanFreqSequence.freq()
     */

    @Test
    public void PrefixSpanExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("PrefixSpanExample");

        String expected = "[" +
                "{\"freq\":3,\"sequence\":[[2]]}," +
                "{\"freq\":2,\"sequence\":[[3]]}," +
                "{\"freq\":3,\"sequence\":[[1]]}," +
                "{\"freq\":3,\"sequence\":[[2,1]]}," +
                "{\"freq\":2,\"sequence\":[[1],[3]]}" +
                "]";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        ALS.train()
        MatrixFactorizationModel.predict()
        Rating()
        Rating.user()
        Rating.product()
        Rating.rating()
        PairRDD.fromRDD()
        PairRDD.join()
        PairRDD.values()
        FloatRDD.fromRDD()
        FloatRDD.mean()
     */

    @Test
    public void RecommendationExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("RecommendationExample");

        String expected = "successful";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    /*
        Vectors.dense()
        RowMatrix()
        RowMatrix.computeSVD()
        SingularValueDecomposition.U()
        SingularValueDecomposition.s()
        SingularValueDecomposition.V()
        
     */

    @Test
    public void SVDExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("SVDExample");

        String expected = "{\"type\":1,\"values\":[27.33836680427936,2.437246301571649,0.6560723589297411]}";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    @Test
    public void SVMwithSGDExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("SVMwithSGDExample");

        String expected = "1.0";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    @Test
    public void RankingMetricExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("RankingMetricExample");

        String expected = "passed";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    @Test
    public void RandomForestClassificationExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("RandomForestClassificationExample");

        String expected = "passed";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    @Test
    public void RandomForestRegressionExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("RandomForestRegressionExample");

        String expected = "passed";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    @Test
    public void RegressionMetricsExample() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        Object ret = ((Invocable)engine).invokeFunction("RegressionMetricsExample");

        String expected = "{\"r2\":0.027639110967836777,\"rootMeanSquaredError\":10.164137288436281,\"meanSquaredError\":103.30968681818085,\"meanAbsoluteError\":8.148691907953307,\"explainedVariance\":2.888395201717894}";

        assertEquals("failure - strings are not equal", expected, ret.toString());

    }

    @Test
    public void SampledRDDs() throws Exception {
        ScriptEngine engine = TestUtils.getEngine();
        //String file = TestUtils.resourceToFile("/data/mllib/lpsa.data");

        TestUtils.evalJSResource(engine, "/mllib/mllibtest.js");
        String ret = (String)  ((Invocable)engine).invokeFunction("SampledRDDs");

        //String expected = "{\"numExamples\":100,\"expectedSampleSize\":10,\"sampledRDD_count\":11,\"sampledArray_length\":10}";
        String expected = "{\"numExamples\":100";


        assertEquals("failure - strings are not equal", expected, ret.substring(0, expected.length()));

    }

}
