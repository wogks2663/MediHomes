'''
Created on 2021. 5. 9.

@author: USER
'''

from tensorflow import keras
import numpy as np 



model = keras.models.load_model("model_save/machinelearning.h5")
model.summary()


data = []
for i in range(0, 850):
    if 7 <  i <= 10:
        data.append(1)
    else:
        data.append(0)
            
test_data = []
test_data.append(data)

#test_loss, test_acc = model.evaluate(X, Y)
#print("evaluate accuracy ", test_acc)

predictions = model.predict(test_data)
predictions = np.argmax(predictions[0])
print(predictions)




















