#include <iostream>
#include "Dataset.h"
#include "Model.h"
#include "GradientDescent.h"          
#include "StochasticGradientDescent.h" 
#include "SupervisedLearner.h"        

int main() {


    Vector v1( std::vector<double> { 0.5, 1.5, 2.5 } );
    Vector v2( std::vector<double> { 8.0, 6.0, 4.0 } );
    Vector v3( std::vector<double> { 3.6, 4.8, 7.2 } );
    
    std::cout << v1 << "\n" << v2 << "\n" << v3 << "\n";
    
    Vector v4 = v1.add( v3 );
    Vector v5 = v2.subtract( v1 );
    Vector v6 = v1.multiply( 4 );
    Vector v7 = v3.divide( 1.2 );
    Vector v8 = v2.multiply( v2 );
    
    std::cout << v4 << "\n" << v5 << "\n" << v6 << "\n" << v7 << "\n" << v8 << "\n";
    
    double d1 = v1.dotProduct( v2 );
    double d2 = v2.norm();
    
    std::cout << d1 << " " << d2 << "\n";

    //y = 2x
    Dataset ds(1);
    ds.addRecord(Record(Vector(std::vector<double>{1.0}), 2.0));
    ds.addRecord(Record(Vector(std::vector<double>{2.0}), 4.0));
    ds.addRecord(Record(Vector(std::vector<double>{3.0}), 6.0));
    ds.addRecord(Record(Vector(std::vector<double>{4.0}), 8.0));


    std::cout << "\n--> Probando Gradient Descent:\n";
    // lr=0.01, sc=0.0001
    GradientDescent* gd = new GradientDescent(0.01, 0.0001);
    SupervisedLearner learnerGD(gd, ds);
    
    learnerGD.solve(); 
    
    // Probamos predicción para 5 (debería dar 10)
    Vector query(std::vector<double>{5.0});
    std::cout << "Prediccion para 5.0: " << learnerGD.predict(query) << "\n";
    
    delete gd;


    std::cout << "\n--> Probando Stochastic Gradient Descent:\n";
    // lr=0.01, batchSize=2, iterations=1500
    StochasticGradientDescent* sgd = new StochasticGradientDescent(0.01, 2, 1500);
    SupervisedLearner learnerSGD(sgd, ds);
    
    learnerSGD.solve(); 
    
    std::cout << "Prediccion para 5.0: " << learnerSGD.predict(query) << "\n";
    delete sgd;

    return 0;
}

